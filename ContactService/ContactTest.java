import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testCreateValidContact() {
        Contact c = new Contact("12345", "Brian", "Minor", "6035551234", "123 Main St");
        assertEquals("12345", c.getContactId());
        assertEquals("Brian", c.getFirstName());
        assertEquals("Minor", c.getLastName());
        assertEquals("6035551234", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    void testContactIdNullThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Brian", "Minor", "6035551234", "123 Main St"));
    }

    @Test
    void testContactIdTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Brian", "Minor", "6035551234", "123 Main St"));
    }

    @Test
    void testFirstNameNullThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", null, "Minor", "6035551234", "123 Main St"));
    }

    @Test
    void testFirstNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "VeryLongFirstName", "Minor", "6035551234", "123 Main St"));
    }

    @Test
    void testLastNameNullThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", null, "6035551234", "123 Main St"));
    }

    @Test
    void testLastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", "VeryLongLastName", "6035551234", "123 Main St"));
    }

    @Test
    void testPhoneNullThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", "Minor", null, "123 Main St"));
    }

    @Test
    void testPhoneNot10DigitsThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", "Minor", "123", "123 Main St"));
    }

    @Test
    void testPhoneNotDigitsThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", "Minor", "60355A1234", "123 Main St"));
    }

    @Test
    void testAddressNullThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", "Minor", "6035551234", null));
    }

    @Test
    void testAddressTooLongThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Brian", "Minor", "6035551234",
                "1234567890123456789012345678901"));
    }
}
