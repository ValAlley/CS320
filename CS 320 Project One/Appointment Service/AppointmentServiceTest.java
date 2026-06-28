import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    
    @Before
    public void setUp() {
        appointmentService = new AppointmentService();
    }
    
    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("A123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment");
        assertTrue(appointmentService.addAppointment(appointment));
    }
    
    @Test
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("A123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment 1");
        Appointment appointment2 = new Appointment("A123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment 2");
        appointmentService.addAppointment(appointment1);
        assertFalse(appointmentService.addAppointment(appointment2));
    }
    
    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("A123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment");
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.deleteAppointment("A123456789"));
    }
    
    @Test
    public void testDeleteNonExistentAppointment() {
        assertFalse(appointmentService.deleteAppointment("B123456789"));
    }
    
    @Test
    public void testGetAppointment() {
        Appointment appointment = new Appointment("A123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("A123456789"));
    }
    
    @Test
    public void testGetNonExistentAppointment() {
        assertNull(appointmentService.getAppointment("B123456789"));
    }
    
    @Test
    public void testGetAppointments() {
        Appointment appointment1 = new Appointment("A123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment 1");
        Appointment appointment2 = new Appointment("B123456789", new Date(System.currentTimeMillis() + 10000), "Test Appointment 2");
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);
        assertEquals(2, appointmentService.getAppointments().size());
    }
}