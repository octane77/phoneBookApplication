package africa.semicolon.phoneBook.dtos.requests;

import lombok.Data;

@Data
public class FindByNameRequestDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
}
