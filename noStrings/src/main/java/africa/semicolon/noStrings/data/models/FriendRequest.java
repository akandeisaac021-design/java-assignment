package africa.semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import africa.semicolon.noStrings.data.enums.FriendRequestStatus;

import java.time.LocalDateTime;

/**
 * A friend request sent from one User to another, carrying an optional
 * message. senderId/receiverId reference User.id - we no longer embed full
 * Seeker/User objects here, which used to make these objects both huge to
 * serialize and easy to get out of sync.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest {

    private String requestId;
    private String senderId;
    private String receiverId;
    private String message;
    private FriendRequestStatus friendRequestStatus;
    private LocalDateTime createdAt;
}
