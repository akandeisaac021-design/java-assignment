package semicolon.noStrings.services;

import semicolon.noStrings.dtos.requests.AcceptFriendRequestRequest;
import semicolon.noStrings.dtos.requests.DeclineFriendRequestRequest;

public class SeekerServices {

    private final AcceptFriendRequestRequest acceptFriendRequest =new AcceptFriendRequestRequest();
    private final DeclineFriendRequestRequest declineFriendRequest =new DeclineFriendRequestRequest();

    public void acceptFriendRequest(){acceptFriendRequest.acceptFriendRequestRequest();}

    public void declineFriendRequest(){
        declineFriendRequest.declineFriendRequestRequest();
    }

}
