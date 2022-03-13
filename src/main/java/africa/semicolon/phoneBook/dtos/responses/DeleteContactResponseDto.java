package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;

@Data
public class DeleteContactResponseDto {
    private String fullName;
    private String mobileNumber;
}
