import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String description;
    
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must not be null and cannot be longer than 10 characters");
        }
        this.appointmentId = appointmentId;
        
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null and cannot be in the past");
        }
        this.appointmentDate = appointmentDate;
        
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and cannot be longer than 50 characters");
        }
        this.description = description;
    }
    
    public String getAppointmentId() {
        return appointmentId;
    }
    
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public String getDescription() {
        return description;
    }
}
