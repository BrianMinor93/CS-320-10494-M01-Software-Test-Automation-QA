package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    @Test
    void testValidAppointmentCreatesSuccessfully() {
        Date future = new Date(System.currentTimeMillis() + 60_000); // +1 minute
        Appointment appt = new Appointment("A123", future, "Routine checkup");
        assertEquals("A123", appt.getAppointmentId());
        assertEquals(future, appt.getAppointmentDate());
        assertEquals("Routine checkup", appt.getDescription());
    }

    // Requirement 1: ID required, <= 10, not null
    @Test
    void testAppointmentIdCannotBeNull() {
        Date future = new Date(System.currentTimeMillis() + 60_000);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment(null, future, "Desc"));
    }

    @Test
    void testAppointmentIdCannotBeLongerThanTen() {
        Date future = new Date(System.currentTimeMillis() + 60_000);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("12345678901", future, "Desc"));
    }

    // Requirement 2: Date required, not null, not in past
    @Test
    void testAppointmentDateCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A123", null, "Desc"));
    }

    @Test
    void testAppointmentDateCannotBeInThePast() {
        Date past = new Date(System.currentTimeMillis() - 60_000); // -1 minute
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A123", past, "Desc"));
    }

    // Requirement 3: Description required, not null, <= 50
    @Test
    void testDescriptionCannotBeNull() {
        Date future = new Date(System.currentTimeMillis() + 60_000);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A123", future, null));
    }

    @Test
    void testDescriptionCannotBeLongerThanFifty() {
        Date future = new Date(System.currentTimeMillis() + 60_000);
        String longDesc = "123456789012345678901234567890123456789012345678901"; // 51 chars
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A123", future, longDesc));
    }
}
