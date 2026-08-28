package africa.semicolon.noStrings.dtos.responses;

import africa.semicolon.noStrings.data.enums.FriendRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestResponse {

    private String requestId;
    private String senderId;
    private String senderName;
    private String receiverId;
    private String receiverName;
    private String message;
    private FriendRequestStatus status;
    private LocalDateTime createdAt;
}
