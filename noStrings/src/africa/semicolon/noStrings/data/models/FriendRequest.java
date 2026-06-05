package semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolon.noStrings.data.enums.FriendRequestStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest{

    private String requestId;
    private Seeker sender;
    private Seeker receiver;
    private String message;
    private FriendRequestStatus friendRequestStatus;

}