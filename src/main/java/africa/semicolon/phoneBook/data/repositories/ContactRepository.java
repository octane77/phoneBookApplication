package africa.semicolon.phoneBook.data.repositories;
import africa.semicolon.phoneBook.data.models.Contact;

public interface ContactRepository {
    Contact saveContact(Contact contact);
    Contact findByName(String name);
    Contact findByNumber(String number);
    void deleteContact(Contact contact);
    void deleteContactByMobile(String mobile);
    int count();

    ContactRepository getRepository();


}
