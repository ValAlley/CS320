import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class AppointmentTest {

    @Test
    public void testCreateAppointment() {
        // Use a time slightly in the future to avoid instant expiration failing the check
        Appointment appointment = new Appointment("A00001", new Date(System.currentTimeMillis() + 10000), "Appointment Description");
        assertNotNull(appointment);
    }

    @Test
    public void testAppointmentID() {
        Appointment appointment = new Appointment("A00001", new Date(System.currentTimeMillis() + 10000), "Appointment Description");
        assertEquals("A00001", appointment.getAppointmentId());
    }

    @Test
    public void testAppointmentDate() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("A00001", appointmentDate, "Appointment Description");
        assertEquals(appointmentDate, appointment.getAppointmentDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateInThePast() {
        Date appointmentDate = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        new Appointment("A00001", appointmentDate, "Appointment Description");
    }

    @Test
    public void testAppointmentDescription() {
        Appointment appointment = new Appointment("A00001", new Date(System.currentTimeMillis() + 10000), "Appointment Description");
        assertEquals("Appointment Description", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIDTooLong() {
        new Appointment("A000000000123", new Date(System.currentTimeMillis() + 10000), "Appointment Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIDNull() {
        new Appointment(null, new Date(System.currentTimeMillis() + 10000), "Appointment Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateNull() {
        new Appointment("A00001", null, "Appointment Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDescriptionNull() {
        new Appointment("A00001", new Date(System.currentTimeMillis() + 10000), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDescriptionTooLong() {
        String description = "Appointment Description that is too long and should throw an IllegalArgumentException";
        new Appointment("A00001", new Date(System.currentTimeMillis() + 10000), description);
    }
}