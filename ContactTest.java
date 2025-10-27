package contactservice; // Package name

import static org.junit.jupiter.api.Assertions.*; // Import assertions for testing
import org.junit.jupiter.api.Test; // Marks test methods

public class ContactTest {

    @Test
    void testValidContactCreation() {
        // Create a valid contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        // Check that all values are set correctly
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        // Test that creating a contact with a null ID throws an error
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testInvalidPhoneNumber() {
        // Test that creating a contact with an invalid phone number throws an error
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    void testUpdateFirstName() {
        // Create a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        // Change the first name
        contact.setFirstName("Mike");
        // Check that the name was updated
        assertEquals("Mike", contact.getFirstName());
    }
}