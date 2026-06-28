package CS320;

import org.junit.*;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setup() {
        taskService = new TaskService();
    }

    @Test
    public void addValidTask() {
        taskService.addTask("1", "Task 1", "Description 1");
        taskService.updateTask("1", "Task 1 Updated", "Description Updated");
        // Implicitly succeeds if no exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateTask() {
        taskService.addTask("1", "Task 1", "Description 1");
        taskService.addTask("1", "Task 2", "Description 2");
    }

    @Test
    public void deleteExistingTask() {
        taskService.addTask("1", "Task 1", "Description 1");
        taskService.deleteTask("1");
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteNonExistentTask() {
        taskService.deleteTask("99");
    }

    @Test(expected = NoSuchElementException.class)
    public void updateNonExistentTask() {
        taskService.updateTask("99", "New Name", "New Desc");
    }
}