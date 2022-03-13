package africa.semicolon.phoneBook.dtos.requests;

import lombok.Data;

@Data
public class DeleteContactRequestDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
}
