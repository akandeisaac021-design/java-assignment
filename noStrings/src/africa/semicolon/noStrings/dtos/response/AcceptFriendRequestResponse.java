package semicolon.noStrings.dtos.response;

import semicolon.noStrings.data.enums.FriendRequestStatus;
import semicolon.noStrings.data.models.FriendRequest;

import static semicolon.noStrings.data.enums.FriendRequestStatus.*;

public class AcceptFriendRequestResponse {

    FriendRequest friendRequest =new FriendRequest();


    public FriendRequestStatus acceptFriendRequestResponse () {

        return ACCEPTED;

    }

}
