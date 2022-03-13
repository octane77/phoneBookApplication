package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;

@Data
public class FindByNameResponseDto  {
    private String fullName;
    private String mobileNumber;

}
