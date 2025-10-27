package contactservice; // Package name

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Store contacts in a map using contactId as the key
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        // Check if contactId already exists
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        // Add contact to the map
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        // Check if contactId exists
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        // Remove contact from the map
        contacts.remove(contactId);
    }

    // Update first name of a contact
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    // Update last name of a contact
    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    // Update phone number of a contact
    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    // Update address of a contact
    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    // Find a contact by ID or throw an error if not found
    private Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contact;
    }
}