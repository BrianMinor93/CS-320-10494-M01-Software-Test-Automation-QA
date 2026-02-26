package appointmentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    @Test
    void testAddAppointmentWithUniqueId() {
        AppointmentService service = new AppointmentService();
        Date future = new Date(System.currentTimeMillis() + 60_000);

        Appointment a1 = new Appointment("A1", future, "First");
        service.addAppointment(a1);

        assertEquals(1, service.size());
        assertNotNull(service.getAppointment("A1"));
        assertEquals("First", service.getAppointment("A1").getDescription());
    }

    @Test
    void testAddAppointmentRejectsDuplicateId() {
        AppointmentService service = new AppointmentService();
        Date future = new Date(System.currentTimeMillis() + 60_000);

        Appointment a1 = new Appointment("A1", future, "First");
        Appointment a2 = new Appointment("A1", future, "Duplicate");

        service.addAppointment(a1);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(a2));
    }

    @Test
    void testDeleteAppointmentById() {
        AppointmentService service = new AppointmentService();
        Date future = new Date(System.currentTimeMillis() + 60_000);

        Appointment a1 = new Appointment("A1", future, "To delete");
        service.addAppointment(a1);

        service.deleteAppointment("A1");
        assertEquals(0, service.size());
        assertNull(service.getAppointment("A1"));
    }

    @Test
    void testDeleteAppointmentThrowsIfIdDoesNotExist() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("NOPE"));
    }
}