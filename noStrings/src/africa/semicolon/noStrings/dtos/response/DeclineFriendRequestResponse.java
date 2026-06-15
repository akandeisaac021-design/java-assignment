package semicolon.noStrings.dtos.response;

import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.data.repositories.FriendRequestRepositoryImpl;

import static semicolon.noStrings.data.enums.FriendRequestStatus.DECLINED;

public class DeclineFriendRequestResponse{


    FriendRequestRepositoryImpl friendRequestRepository =new FriendRequestRepositoryImpl();
    FriendRequest friendRequest =new FriendRequest();

    public void declineFriendRequestResponse () {
        friendRequest.setFriendRequestStatus(DECLINED);
        friendRequestRepository.save(friendRequest);
    }
}
