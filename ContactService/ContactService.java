import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        String id = contact.getContactId();

        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }

        contacts.put(id, contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact c = getRequiredContact(contactId);
        c.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact c = getRequiredContact(contactId);
        c.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact c = getRequiredContact(contactId);
        c.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact c = getRequiredContact(contactId);
        c.setAddress(address);
    }

    // helper method for tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    private Contact getRequiredContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        Contact c = contacts.get(contactId);

        if (c == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        return c;
    }
}
