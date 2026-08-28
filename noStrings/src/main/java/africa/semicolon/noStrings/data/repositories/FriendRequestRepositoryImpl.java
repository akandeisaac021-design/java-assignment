package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.FriendRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FriendRequestRepositoryImpl implements FriendRequestRepository {

    private final Map<String, FriendRequest> requestsById = new ConcurrentHashMap<>();

    @Override
    public FriendRequest save(FriendRequest friendRequest) {
        if (friendRequest == null) {
            return null;
        }
        if (friendRequest.getRequestId() == null || friendRequest.getRequestId().isBlank()) {
            friendRequest.setRequestId("FR-" + UUID.randomUUID());
        }
        requestsById.put(friendRequest.getRequestId(), friendRequest);
        return friendRequest;
    }

    @Override
    public Optional<FriendRequest> findById(String requestId) {
        if (requestId == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(requestsById.get(requestId));
    }

    @Override
    public List<FriendRequest> findAll() {
        return new ArrayList<>(requestsById.values());
    }

    @Override
    public List<FriendRequest> findByReceiverId(String receiverId) {
        return requestsById.values().stream()
                .filter(request -> request.getReceiverId() != null && request.getReceiverId().equals(receiverId))
                .toList();
    }

    @Override
    public List<FriendRequest> findBySenderId(String senderId) {
        return requestsById.values().stream()
                .filter(request -> request.getSenderId() != null && request.getSenderId().equals(senderId))
                .toList();
    }

    @Override
    public void deleteAll() {
        requestsById.clear();
    }
}
