package taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testCreateValidTask() {
        Task task = new Task("12345", "My Task", "This is a description.");
        assertEquals("12345", task.getTaskId());
        assertEquals("My Task", task.getName());
        assertEquals("This is a description.", task.getDescription());
    }

    // Requirement: ID not null, <= 10, not updatable (final + no setter)
    @Test
    void testTaskIdNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task(null, "Name", "Description"));
    }

    @Test
    void testTaskIdTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("12345678901", "Name", "Description"));
    }

    // Requirement: name not null, <= 20
    @Test
    void testNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", null, "Description"));
    }

    @Test
    void testNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", "123456789012345678901", "Description")); // 21
    }

    // Requirement: description not null, <= 50
    @Test
    void testDescriptionNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", "Name", null));
    }

    @Test
    void testDescriptionTooLongThrows() {
        String longDesc = "123456789012345678901234567890123456789012345678901"; // 51
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1", "Name", longDesc));
    }

    @Test
    void testUpdateNameValid() {
        Task task = new Task("1", "Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    void testUpdateDescriptionValid() {
        Task task = new Task("1", "Name", "Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
}
