package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequestDto;
import africa.semicolon.phoneBook.dtos.requests.DeleteContactRequestDto;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.DeleteContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.FindByNameResponseDto;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {
    ContactService contactService = new ContactServiceImpl();

    @PostMapping("/saveContact")
    public AddContactResponseDto saveContact(@RequestBody AddContactRequestDto contact) {
        return contactService.save(contact);
    }

    @DeleteMapping("/{deleteContact}")
    public DeleteContactResponseDto deleteContact(@RequestBody DeleteContactRequestDto contact, @PathVariable String deleteContact) {
        return contactService.delete(contact);
    }
    }

