package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequestDto;
import africa.semicolon.phoneBook.dtos.requests.DeleteContactRequestDto;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.FindByNameResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    ContactService contactService;
    @BeforeEach
    void setUp(){
        contactService = new ContactServiceImpl();
    }

    @Test
    public void testThatAllRequiredParamsAreNotNull(){
        AddContactRequestDto request = new AddContactRequestDto();
        request.setFirstName("October");
        request.setLastName("Eagle");
        request.setMobileNumber("08029682172");

        AddContactResponseDto response = contactService.save(request);
        assertEquals(1, contactService.getRepository().count());
        assertNotNull(response);
    }

    @Test
    public void testThatContactsCanBeAdded(){
        AddContactRequestDto request = new AddContactRequestDto();
        request.setFirstName("Lotachukwu");
        request.setLastName("Onwuka");
        request.setMobileNumber("90210");
        contactService.save(request);

        assertEquals(1, contactService.getRepository().count());
    }

    @Test
    public void testThatContactsCanBeDeleted(){
        ContactService contactService = new ContactServiceImpl();
        AddContactRequestDto request = new AddContactRequestDto();
        request.setFirstName("Lotachukwu");
        request.setLastName("Onwuka");
        request.setMobileNumber("90210");
        contactService.save(request);

        AddContactRequestDto request1 = new AddContactRequestDto();
        request1.setFirstName("Samuel");
        request1.setLastName("Lotachukwu");
        request1.setMobileNumber("96210");
        contactService.save(request1);

        assertEquals(2, contactService.getRepository().count());

        DeleteContactRequestDto deleteRequest = new DeleteContactRequestDto();
        deleteRequest.setFirstName("Lotachukwu");
        deleteRequest.setLastName("Onwuka");
        deleteRequest.setMobileNumber("90210");
        contactService.delete(deleteRequest);
        assertEquals(1, contactService.getRepository().count());
    }

    @Test
    public void testThatContactsCanBeRetrievedByFirstName(){
        ContactService contactService = new ContactServiceImpl();
        AddContactRequestDto request = new AddContactRequestDto();
        request.setFirstName("Lotachukwu");
        request.setLastName("Onwuka");
        request.setMobileNumber("90210");
        contactService.save(request);

        assertEquals(1, contactService.getRepository().count());
    }

    @Test
    public void testThatContactsCanBeRetrievedByLastName(){
        ContactService contactService = new ContactServiceImpl();
        AddContactRequestDto request = new AddContactRequestDto();
        request.setFirstName("Lotachukwu");
        request.setLastName("Onwuka");
        request.setMobileNumber("90210");
        contactService.save(request);

        assertEquals(1, contactService.getRepository().count());
    }

    @Test
    public void testThatContactsCanBeRetrievedByMobileNumber(){
        ContactService contactService = new ContactServiceImpl();
        AddContactRequestDto request = new AddContactRequestDto();
        request.setFirstName("Lotachukwu");
        request.setLastName("Onwuka");
        request.setMobileNumber("90210");
        contactService.save(request);

        assertEquals(1, contactService.getRepository().count());
    }

}