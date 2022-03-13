import africa.semicolon.phoneBook.controllers.ContactController;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequestDto;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponseDto;
import africa.semicolon.phoneBook.dtos.responses.FindByNameResponseDto;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Main {
    public static ContactController contactController = new ContactController();
    public static void main(String[] args) {
//        Contact contact = new Contact("Ojo", "90210");
//        Contact contact1 = new Contact("firstName", "LastName", "Middlename", "Mobile", "Office");
        SpringApplication.run(Main.class, args);
        loadOptions();

//        TODO
//        Repository, Contact Repository CRUD (Done)
//        Services = Delete Contact, Save Contact, Find Contact by firstName, lastName
//        API = Expose the APIs (Controllers)

    }

    private static void loadOptions() {
        String option = """
                -> Type A to Register
                -> Type B to Search by Email
                -> Type C to Add A Package
                """;
        String input = collectStringInput(option);
        switch(input.toLowerCase()){
            case "a" -> createContactForm();
            case "b" -> searchContactForm();
            case "c" -> deleteContactForm();
            case "d" -> updateContactForm();
            default -> {
                display("Invalid Input");
                loadOptions();
            }
        }
    }

    private static void updateContactForm() {
        loadOptions();
    }

    private static void deleteContactForm() {
        loadOptions();
    }

    private static void searchContactForm() {
//        String contactName = collectStringInput("Enter a contact name: ");
//        FindByNameResponseDto response = contactController.
//        display(response.toString());
//        loadOptions();
    }

    private static void createContactForm() {
        AddContactRequestDto newContact = new AddContactRequestDto();
        newContact.setFirstName(collectStringInput("Contact Firstname: "));
        newContact.setLastName(collectStringInput("Contact LastName: "));
        newContact.setMobileNumber(collectStringInput("Contact Mobile Number: "));
        AddContactResponseDto response = contactController.saveContact(newContact);
        display(response.toString());
        loadOptions();
    }

    private static String collectStringInput(String message) {
        Scanner keyboardInput = new Scanner(System.in);
        display(message);
        return keyboardInput.nextLine();
    }

    private static void display(String message) {
        System.out.println(message);
    }
}

