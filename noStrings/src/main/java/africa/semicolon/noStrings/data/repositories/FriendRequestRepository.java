package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.FriendRequest;

import java.util.List;
import java.util.Optional;

public interface FriendRequestRepository {

    FriendRequest save(FriendRequest friendRequest);

    Optional<FriendRequest> findById(String requestId);

    List<FriendRequest> findAll();

    List<FriendRequest> findByReceiverId(String receiverId);

    List<FriendRequest> findBySenderId(String senderId);

    void deleteAll();
}
