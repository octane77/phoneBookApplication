package africa.semicolon.phoneBook.dtos.responses;
import lombok.Data;

@Data
public class AddContactResponseDto {
    private String fullName;
    private String mobileNumber;
}
