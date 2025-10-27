package contactservice; // Package name

import static org.junit.jupiter.api.Assertions.*; // Import assertions for testing
import org.junit.jupiter.api.BeforeEach; // Runs before each test
import org.junit.jupiter.api.Test; // Marks test methods

public class ContactServiceTest {

    private ContactService service; // ContactService instance for testing

    @BeforeEach
    void setUp() {
        service = new ContactService(); // Create a new ContactService before each test
    }

    @Test
    void testAddContact() {
        // Create a new contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        // Add the contact
        service.addContact(contact);
        // Test that adding the same contact again throws an error
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        // Delete the contact
        service.deleteContact("12345");
        // Test that deleting again throws an error
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("12345"));
    }

    @Test
    void testUpdateContact() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        // Update first name and check if it changed
        service.updateFirstName("12345", "Mike");
        assertEquals("Mike", contact.getFirstName());

        // Update phone number and check if it changed
        service.updatePhone("12345", "0987654321");
        assertEquals("0987654321", contact.getPhone());
    }
}