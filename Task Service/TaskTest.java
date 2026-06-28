package CS320;

import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {
    @Test
    public void createValidTask() {
        Task task = new Task("1", "Task 1", "Description 1");
        assertEquals("1", task.getTaskId());
        assertEquals("Task 1", task.getName());
        assertEquals("Description 1", task.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTaskIDTooLong() {
        new Task("12345678901", "Task 1", "Description 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskNameTooLong() {
        new Task("1", "This Name Is Way Too Long", "Description 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskDescriptionTooLong() {
        new Task("1", "Task 1", "This description is entirely too long and should trigger an exception according to requirements.");
    }
}