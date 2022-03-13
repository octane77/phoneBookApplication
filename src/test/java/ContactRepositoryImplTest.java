import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;
    @BeforeEach
    void setup(){
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void contactCanBeSavedTest(){
        //Given that we have a contact;
        //Validate that contact exists
        //Inspect the size of the contact db

        Contact contact = new Contact("Emmanuel", "Upah", "08029682172");
        Contact contact1 = new Contact("Increase", "Lois", "07029682172");
        contactRepository.saveContact(contact);
        contactRepository.saveContact(contact1);
        assertEquals(2, contactRepository.count());
    }

    @Test
    public void contactCanBeDeletedTest(){
        //Given that the db contains created contacts
        //Delete specified contact
        //Inspect that the size of the db decrements

        Contact contact = new Contact("October", "Eagle", "08029682172");
        contactRepository.saveContact(contact);
        Contact contact1 = new Contact("Isiah", "Jeremy", "08029682172");
        contactRepository.saveContact(contact1);
        assertEquals(2, contactRepository.count());

        contactRepository.deleteContact(contact1);
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void contactCanBeDeletedByMobileNumberTest(){
        //Given that the db contains created contacts
        //Delete specified contact
        //Inspect that the size of the db decrements

        Contact contact = new Contact("October", "Eagle", "08029682172");
        contactRepository.saveContact(contact);
        Contact contact1 = new Contact("Isiah", "Jeremy", "08029682172");
        contactRepository.saveContact(contact1);
        assertEquals(2, contactRepository.count());

        contactRepository.deleteContactByMobile("08029682172");
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void contactCanBeRetrievedByFirstName(){
        //Given that we have saved contacts;
        //Confirm that we can retrieve items from the db using the search value of firstName;

        Contact contact = new Contact("Patience", "Alao", "07029682172");
        contactRepository.saveContact(contact);
        Contact contact1 = new Contact("Adeola", "Oladeji", "01029682172");
        contactRepository.saveContact(contact1);
        assertEquals(2, contactRepository.count());

        Contact foundContact = contactRepository.findByName("Patience");
        assertEquals(contact, foundContact);
    }

    @Test
    public void contactCanBeRetrievedByLastName(){
        //Given that we have saved contacts;
        //Confirm that we can retrieve items from the db using the search value of lastName;

        Contact contact = new Contact("Patience", "Alao", "07029682172");
        contactRepository.saveContact(contact);
        Contact contact1 = new Contact("Adeola", "Oladeji", "01029682172");
        contactRepository.saveContact(contact1);
//        assertEquals(2, contactRepository.count());

        Contact foundContact = contactRepository.findByName("Alao");
        assertEquals(contact, foundContact);
    }

    @Test
    public void contactCanBeRetrievedByMobileNumberTest(){
        //Given that we have saved contacts;
        //Confirm that we can retrieve items from the db using the search value of mobileNumber;

        Contact contact = new Contact("Patience", "Alao", "07029682172");
        contactRepository.saveContact(contact);
        Contact contact1 = new Contact("Adeola", "Oladeji", "01029682172");
        contactRepository.saveContact(contact1);

        Contact foundContact = contactRepository.findByNumber("07029682172");
        assertEquals(contact, foundContact);
    }

    @Test
    public void contactCanBeUpdated() {
        //Given that we have saved contacts;
        //Confirm that we can update the values of previously stored parameters

        Contact contact = new Contact("October", "Eagle", "08029682172");
        contactRepository.saveContact(contact);
        Contact contact1 = new Contact("Isiah", "Jeremy", "08029682172");
        contactRepository.saveContact(contact1);

        contact1.setFirstName("Jeremiah");
        contactRepository.saveContact(contact1);
        Contact foundContact = contactRepository.findByName("Jeremiah");
        assertEquals(contact1, foundContact);
    }

}