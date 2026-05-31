package semicolon.noStrings.dtos.requests;

import semicolon.noStrings.data.enums.FriendRequestStatus;
import semicolon.noStrings.dtos.response.AcceptFriendRequestResponse;

import static semicolon.noStrings.data.enums.FriendRequestStatus.*;

public class AcceptFriendRequestRequest{

    FriendRequestStatus status =PENDING;
    AcceptFriendRequestResponse response =new AcceptFriendRequestResponse();

    public FriendRequestStatus acceptFriendRequestRequest(){

        if (status == PENDING || status == ACCEPTED){
            return status = response.acceptFriendRequestResponse();
        }

        return DECLINED;
    }
}
