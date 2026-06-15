package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.FriendRequest;

public interface FriendRequestRepository {
     void save(FriendRequest friendRequest);

    FriendRequest searchForRequestById(String requestId);

     void deleteAll();
}

