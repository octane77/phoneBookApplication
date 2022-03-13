package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequestDto;
import africa.semicolon.phoneBook.dtos.requests.DeleteContactRequestDto;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.DeleteContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.FindByNameResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService{
//    List<Contact> repository = new ArrayList<>();
    ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public AddContactResponseDto save(AddContactRequestDto request) {
        Contact contactToSave = new Contact(request.getFirstName(), request.getLastName(), request.getMobileNumber());
        contactRepository.saveContact(contactToSave);

        AddContactResponseDto response = new AddContactResponseDto();
        response.setFullName(contactToSave.getFirstName() + ", " +  contactToSave.getLastName());
        response.setMobileNumber(contactToSave.getMobile());
        return response;
    }

    @Override
    public DeleteContactResponseDto delete(DeleteContactRequestDto deleteRequest) {
        Contact contactToDelete = new Contact(deleteRequest.getFirstName(), deleteRequest.getLastName(), deleteRequest.getMobileNumber());
        contactRepository.deleteContact(contactToDelete);
        return null;
    }

    @Override
    public FindByNameResponseDto findByName(String name) {
        return null;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }
}
