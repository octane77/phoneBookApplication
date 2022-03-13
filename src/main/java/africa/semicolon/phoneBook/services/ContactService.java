package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequestDto;
import africa.semicolon.phoneBook.dtos.requests.DeleteContactRequestDto;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.DeleteContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.FindByNameResponseDto;

public interface ContactService {
    AddContactResponseDto save(AddContactRequestDto request);
    DeleteContactResponseDto delete(DeleteContactRequestDto request);
    FindByNameResponseDto findByName(String name);
    ContactRepository getRepository();
}
