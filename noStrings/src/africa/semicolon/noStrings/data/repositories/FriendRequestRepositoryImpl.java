package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.FriendRequest;

import java.util.ArrayList;
import java.util.List;

public class FriendRequestRepositoryImpl implements FriendRequestRepository{

    private final List<FriendRequest> friendRequestDatabase = new ArrayList<>();

    @Override
    public void save(FriendRequest friendRequest) {
        if (friendRequest == null) {
            return;
        }

        if (friendRequest.getRequestId() != null && !friendRequest.getRequestId().isEmpty()) {
            for (int index = 0; index < friendRequestDatabase.size(); index++) {
                if (friendRequestDatabase.get(index).getRequestId().equals(friendRequest.getRequestId())) {
                    friendRequestDatabase.set(index, friendRequest);
                    return;
                }
            }
        }
        friendRequestDatabase.add(friendRequest);
    }

    @Override
    public FriendRequest searchForRequestById(String requestId) {
        boolean matchFound = false;

        for (FriendRequest friendRequest : friendRequestDatabase){
            if (friendRequest.getRequestId().equals(requestId)) {
                return friendRequest;
            }
        }

        if (!matchFound) {
            System.out.println("No matching profiles found.");
        }
    }

    @Override
    public void deleteAll() {
        friendRequestDatabase.clear();
    }
}