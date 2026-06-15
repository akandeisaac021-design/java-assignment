package semicolon.noStrings.dtos.response;

import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.data.repositories.FriendRequestRepositoryImpl;

import static semicolon.noStrings.data.enums.FriendRequestStatus.*;

public class AcceptFriendRequestResponse {

    FriendRequestRepositoryImpl friendRequestRepository =new FriendRequestRepositoryImpl();
    FriendRequest friendRequest =new FriendRequest();

    public void acceptFriendRequestResponse () {
        friendRequest.setFriendRequestStatus(ACCEPTED);
        friendRequestRepository.save(friendRequest);
    }

}