import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;
    
    public AppointmentService() {
        appointments = new ArrayList<>();
    }
    
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment must not be null");
        }
        
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
                return false; // Based on your tests, duplicates return false
            }
        }
        
        appointments.add(appointment);
        return true;
    }
    
    public boolean deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID must not be null");
        }
        
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Appointment getAppointment(String appointmentId) {
        for (Appointment appt : appointments) {
            if (appt.getAppointmentId().equals(appointmentId)) {
                return appt;
            }
        }
        return null;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}