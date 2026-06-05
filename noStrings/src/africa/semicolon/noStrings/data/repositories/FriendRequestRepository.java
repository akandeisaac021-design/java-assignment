package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.data.models.Profile;

public interface FriendRequestRepository {
     void save(FriendRequest friendRequest);

    FriendRequest searchForRequestById(String requestId);

     void deleteAll();
}

