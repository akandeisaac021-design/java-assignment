package africa.semicolon.noStrings.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendFriendRequestRequest {

    @NotBlank(message = "senderId is required")
    private String senderId;

    @NotBlank(message = "receiverId is required")
    private String receiverId;

    private String message;
}
