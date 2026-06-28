package cs320;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact cannot be null or already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setFirstName(newFirstName);
    }

    public void updateLastName(String contactID, String newLastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setLastName(newLastName);
    }

    public void updatePhone(String contactID, String newPhone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setPhone(newPhone);
    }

    public void updateAddress(String contactID, String newAddress) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setAddress(newAddress);
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}