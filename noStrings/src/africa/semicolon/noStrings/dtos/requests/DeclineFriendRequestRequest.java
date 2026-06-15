package semicolon.noStrings.dtos.requests;

import semicolon.noStrings.data.enums.FriendRequestStatus;
import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.dtos.response.DeclineFriendRequestResponse;

import static semicolon.noStrings.data.enums.FriendRequestStatus.*;

public class DeclineFriendRequestRequest{

    FriendRequest friendRequest =new FriendRequest();
    FriendRequestStatus status =friendRequest.getFriendRequestStatus();

    DeclineFriendRequestResponse response =new DeclineFriendRequestResponse();

    public void declineFriendRequestRequest(){

        if (status == PENDING || status == DECLINED){
            response.declineFriendRequestResponse();
            return;
        }

        friendRequest.setFriendRequestStatus(DECLINED);
    }
}