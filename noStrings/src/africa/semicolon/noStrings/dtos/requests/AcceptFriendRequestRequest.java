package semicolon.noStrings.dtos.requests;

import semicolon.noStrings.data.enums.FriendRequestStatus;
import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.dtos.response.AcceptFriendRequestResponse;

import static semicolon.noStrings.data.enums.FriendRequestStatus.*;

public class AcceptFriendRequestRequest{

    FriendRequest friendRequest =new FriendRequest();
    FriendRequestStatus status =friendRequest.getFriendRequestStatus();


    AcceptFriendRequestResponse response =new AcceptFriendRequestResponse();


    public void acceptFriendRequestRequest(){

        if (status == PENDING || status == ACCEPTED){
            response.acceptFriendRequestResponse();
            return;
        }
        friendRequest.setFriendRequestStatus(DECLINED);
    }
}