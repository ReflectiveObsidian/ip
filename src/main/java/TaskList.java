import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
public class TaskList implements Serializable {
    private ArrayList<Task> list = new ArrayList<>();
    public int indexOf(Task task) {
        return this.list.indexOf(task);
    }
    public int size() {
        return this.list.size();
    }
    public String toString(){
        String output = "";
        for (Task t : this.list) {
            output += (this.list.indexOf(t) + 1) + ". " + t.toString();
            output += "\n";
        }
        return output;
    }
    public String toString(int id) {
        return this.list.get(id).toString();
    }
    public void setDone(int id, boolean isDone) {
        this.list.get(id).setDone(isDone);
    }
    public void remove(int id) {
        this.list.remove(id);
    }
    public void add(Task task) {
        this.list.add(task);
    }
}
