package cs320;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"); // Too long
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"); // Null
        });
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Johnnnnnnnn", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St"); // Too short
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789A", "123 Main St"); // Non-digits
        });
    }
}