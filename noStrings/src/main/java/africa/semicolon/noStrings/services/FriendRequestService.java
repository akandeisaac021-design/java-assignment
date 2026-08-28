package africa.semicolon.noStrings.services;

import africa.semicolon.noStrings.dtos.requests.SendFriendRequestRequest;
import africa.semicolon.noStrings.dtos.responses.FriendRequestResponse;

import java.util.List;

public interface FriendRequestService {

    FriendRequestResponse sendFriendRequest(SendFriendRequestRequest request);

    FriendRequestResponse acceptFriendRequest(String requestId);

    FriendRequestResponse declineFriendRequest(String requestId);

    List<FriendRequestResponse> findAllFriendRequests();

    List<FriendRequestResponse> findInbox(String userId);
}
