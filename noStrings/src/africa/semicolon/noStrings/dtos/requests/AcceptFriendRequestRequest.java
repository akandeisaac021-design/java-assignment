package semicolon.noStrings.dtos.requests;

import semicolon.noStrings.data.enums.FriendRequestStatus;
import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.data.repositories.FriendRequestRepositoryImpl;

import static semicolon.noStrings.data.enums.FriendRequestStatus.*;

public class AcceptFriendRequestRequest{

    FriendRequest friendRequest =new FriendRequest();
    FriendRequestRepositoryImpl response =new FriendRequestRepositoryImpl();

    FriendRequest friendRequestId =response.searchForRequestById("Some random Friend request Id");
    FriendRequestStatus status =friendRequest.getFriendRequestStatus();

    public void acceptFriendRequestRequest(){

        if (status == PENDING || status == ACCEPTED){
            friendRequest.setFriendRequestStatus(ACCEPTED);
            return;
        }

        friendRequest.setFriendRequestStatus(DECLINED);
    }
}