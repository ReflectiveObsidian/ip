package pyrite;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StateFile {
    private static final String FILE_PATH = "saves/state.txt";
    //  Solution below (use of ObjectOutputStream and FileOutputStream) inspired by ChatGPT
    private void saveObject(TaskList object) throws IOException {
        // Create directory if it does not exist
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
        FileOutputStream fileStream = new FileOutputStream(FILE_PATH);
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
        objectStream.writeObject(object);
        objectStream.close();
        fileStream.close();
    }
    private TaskList loadObject() throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(FILE_PATH);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        TaskList list;
        try {
            list = (TaskList) objectStream.readObject();
        } finally {
            objectStream.close();
            fileStream.close();
        }
        return list;
    }
    public TaskList loadState(TaskList tasks) {
        try {
            TaskList loadedTasks = this.loadObject();
            return loadedTasks;
        } catch (IOException | ClassNotFoundException e){
            // File issue, try to save blank state
            System.out.println("Unable to read saved state, creating new file...");
            this.saveState(tasks);
        }
        return tasks;
    }
    public String saveState(TaskList tasks) {
        try {
            this.saveObject(tasks);
        } catch (IOException e){
            return "Unable to save state: " + e.toString();
        }
        return "";
    }
}
