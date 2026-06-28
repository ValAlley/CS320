package CS320;

import java.util.*;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();
    
    public void addTask(String taskId, String name, String description) {
        if(tasks.containsKey(taskId)) throw new IllegalArgumentException("Task ID already exists");
        tasks.put(taskId, new Task(taskId, name, description));
    }
    
    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }
    
    public void updateTask(String taskId, String newName, String newDescription) {
        Task task = tasks.get(taskId);
        if(task == null) throw new NoSuchElementException("Task ID does not exist");
        
        task.setName(newName);
        task.setDescription(newDescription);
    }
}