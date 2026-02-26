package taskservice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Add tasks with unique ID
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        String id = task.getTaskId();
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        tasks.put(id, task);
    }

    // Delete tasks per task ID
    public void deleteTask(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        }
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskId);
    }

    // Update task fields per task ID (Name + Description only)
    public void updateTaskName(String taskId, String newName) {
        Task t = getExistingTask(taskId);
        t.setName(newName);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task t = getExistingTask(taskId);
        t.setDescription(newDescription);
    }

    // Helper used by tests / internal logic
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    public Map<String, Task> getAllTasksReadOnly() {
        return Collections.unmodifiableMap(tasks);
    }

    private Task getExistingTask(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        }
        Task t = tasks.get(taskId);
        if (t == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        return t;
    }
}