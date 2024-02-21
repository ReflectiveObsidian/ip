package pyrite.task;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DeadlineTest {
    @Test
    public void toString_success() {
        Deadline deadline = new Deadline("test", LocalDateTime.parse("2024-01-01T00:00"));
        assertTrue(deadline.toString().equals("[D][ ] test (by: Jan 1 2024, 00:00)"));
    }
}
