package appointmentservice;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();

    // Requirement: add appointments with a unique appointment ID
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        String id = appointment.getAppointmentId();
        if (appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        appointments.put(id, appointment);
    }

    // Requirement: delete appointments per appointment ID
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment ID cannot be null or empty.");
        }

        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }

        appointments.remove(appointmentId);
    }

    // Helper for testing (not required by rubric)
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }

    // Helper for testing (not required by rubric)
    public int size() {
        return appointments.size();
    }
}