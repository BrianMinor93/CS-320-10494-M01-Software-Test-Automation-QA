import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Brian", "Minor", "6035551234", "123 Main St");

        service.addContact(contact);

        assertNotNull(service.getContact("1"));
        assertEquals("Brian", service.getContact("1").getFirstName());
    }

    @Test
    void testAddDuplicateIdThrows() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Brian", "Minor", "6035551234", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
            service.addContact(new Contact("1", "Jane", "Doe", "2075550000", "456 Oak St")));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Brian", "Minor", "6035551234", "123 Main St"));

        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    void testDeleteNonexistentThrows() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->
            service.deleteContact("99"));
    }

    @Test
    void testUpdateFields() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Brian", "Minor", "6035551234", "123 Main St"));

        service.updateFirstName("1", "Bryan");
        service.updateLastName("1", "Minor2");
        service.updatePhone("1", "2075550000");
        service.updateAddress("1", "456 Oak St");

        Contact updated = service.getContact("1");
        assertEquals("Bryan", updated.getFirstName());
        assertEquals("Minor2", updated.getLastName());
        assertEquals("2075550000", updated.getPhone());
        assertEquals("456 Oak St", updated.getAddress());
    }

    @Test
    void testUpdateInvalidPhoneThrows() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Brian", "Minor", "6035551234", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("1", "123"));
    }
}
