package taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    void testAddTaskUniqueId() {
        TaskService service = new TaskService();
        Task t1 = new Task("A1", "Task One", "Desc One");
        service.addTask(t1);

        assertNotNull(service.getTask("A1"));
        assertEquals("Task One", service.getTask("A1").getName());
    }

    @Test
    void testAddTaskDuplicateIdThrows() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Task One", "Desc One"));

        assertThrows(IllegalArgumentException.class,
                () -> service.addTask(new Task("A1", "Task Two", "Desc Two")));
    }

    @Test
    void testDeleteTaskById() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Task One", "Desc One"));

        service.deleteTask("A1");
        assertNull(service.getTask("A1"));
    }

    @Test
    void testDeleteMissingIdThrows() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("NOPE"));
    }

    @Test
    void testUpdateNameById() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Task One", "Desc One"));

        service.updateTaskName("A1", "Updated Name");
        assertEquals("Updated Name", service.getTask("A1").getName());
    }

    @Test
    void testUpdateDescriptionById() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Task One", "Desc One"));

        service.updateTaskDescription("A1", "Updated Desc");
        assertEquals("Updated Desc", service.getTask("A1").getDescription());
    }

    @Test
    void testUpdateMissingIdThrows() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class,
                () -> service.updateTaskName("NOPE", "Name"));
    }
}
