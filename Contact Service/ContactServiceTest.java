package cs320;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateFields() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateFirstName("1234567890", "Jane");
        contactService.updateLastName("1234567890", "Smith");
        contactService.updatePhone("1234567890", "0987654321");
        contactService.updateAddress("1234567890", "456 Elm St");

        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }
}