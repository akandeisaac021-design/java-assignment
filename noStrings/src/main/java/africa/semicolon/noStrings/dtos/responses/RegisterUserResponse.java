package africa.semicolon.noStrings.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponse {

    private String userId;
    private String seekerId;
    private String email;
    private String fullName;
    private String message;
}
