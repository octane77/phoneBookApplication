package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    private List<Contact> db = new ArrayList<>();

    @Override
    public Contact saveContact(Contact contact) {
        db.add(contact);
        return contact;
    }

    @Override
    public Contact findByName(String name) {
        for (Contact contact : db) {
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findByNumber(String number) {
        for (Contact contact : db) {
            if (contact.getMobile().equalsIgnoreCase(number) || contact.getLastName().equalsIgnoreCase(number)) {
                return contact;
            } else {
                throw new IllegalArgumentException("Contact does not exist");
            }
        }
        return null;
    }

    @Override
    public void deleteContact(Contact contact) {
        db.remove(contact);
    }

    @Override
    public void deleteContactByMobile(String mobile) {
        for (Contact contact : db) {
            if (mobile.equals(contact.getMobile())) {
                db.remove(contact);
                break;
            }
        }
    }

    @Override
    public int count() {
        return db.size();
    }

    @Override
    public ContactRepository getRepository() {
        return null;
    }
}