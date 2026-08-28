package africa.semicolon.noStrings.services;

import africa.semicolon.noStrings.data.enums.FriendRequestStatus;
import africa.semicolon.noStrings.data.models.FriendRequest;
import africa.semicolon.noStrings.data.models.Seeker;
import africa.semicolon.noStrings.data.models.User;
import africa.semicolon.noStrings.data.repositories.FriendRequestRepository;
import africa.semicolon.noStrings.data.repositories.SeekerRepository;
import africa.semicolon.noStrings.data.repositories.UserRepository;
import africa.semicolon.noStrings.dtos.requests.SendFriendRequestRequest;
import africa.semicolon.noStrings.dtos.responses.FriendRequestResponse;
import africa.semicolon.noStrings.exceptions.FriendRequestNotFoundException;
import africa.semicolon.noStrings.exceptions.InvalidFriendRequestActionException;
import africa.semicolon.noStrings.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {

    private final FriendRequestRepository friendRequestRepository;
    private final UserRepository userRepository;
    private final SeekerRepository seekerRepository;

    public FriendRequestServiceImpl(FriendRequestRepository friendRequestRepository,
                                     UserRepository userRepository,
                                     SeekerRepository seekerRepository) {
        this.friendRequestRepository = friendRequestRepository;
        this.userRepository = userRepository;
        this.seekerRepository = seekerRepository;
    }

    @Override
    public FriendRequestResponse sendFriendRequest(SendFriendRequestRequest request) {
        if (request.getSenderId().equals(request.getReceiverId())) {
            throw new InvalidFriendRequestActionException("You cannot send a friend request to yourself");
        }

        User sender = getUser(request.getSenderId());
        User receiver = getUser(request.getReceiverId());

        boolean alreadyPending = friendRequestRepository.findBySenderId(sender.getId()).stream()
                .anyMatch(existing -> existing.getReceiverId().equals(receiver.getId())
                        && existing.getFriendRequestStatus() == FriendRequestStatus.PENDING);
        if (alreadyPending) {
            throw new InvalidFriendRequestActionException("A pending friend request to this user already exists");
        }

        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setSenderId(sender.getId());
        friendRequest.setReceiverId(receiver.getId());
        friendRequest.setMessage(request.getMessage());
        friendRequest.setFriendRequestStatus(FriendRequestStatus.PENDING);
        friendRequest.setCreatedAt(LocalDateTime.now());

        FriendRequest saved = friendRequestRepository.save(friendRequest);
        return toResponse(saved, sender, receiver);
    }

    @Override
    public FriendRequestResponse acceptFriendRequest(String requestId) {
        FriendRequest friendRequest = getRequestOrThrow(requestId);
        requirePending(friendRequest);

        friendRequest.setFriendRequestStatus(FriendRequestStatus.ACCEPTED);
        friendRequestRepository.save(friendRequest);

        linkAsFriends(friendRequest.getSenderId(), friendRequest.getReceiverId());

        return toResponse(friendRequest,
                getUser(friendRequest.getSenderId()),
                getUser(friendRequest.getReceiverId()));
    }

    @Override
    public FriendRequestResponse declineFriendRequest(String requestId) {
        FriendRequest friendRequest = getRequestOrThrow(requestId);
        requirePending(friendRequest);

        friendRequest.setFriendRequestStatus(FriendRequestStatus.DECLINED);
        friendRequestRepository.save(friendRequest);

        return toResponse(friendRequest,
                getUser(friendRequest.getSenderId()),
                getUser(friendRequest.getReceiverId()));
    }

    @Override
    public List<FriendRequestResponse> findAllFriendRequests() {
        return friendRequestRepository.findAll().stream()
                .map(fr -> toResponse(fr, getUser(fr.getSenderId()), getUser(fr.getReceiverId())))
                .toList();
    }

    @Override
    public List<FriendRequestResponse> findInbox(String userId) {
        getUser(userId); // 404 early if the user doesn't exist
        return friendRequestRepository.findByReceiverId(userId).stream()
                .map(fr -> toResponse(fr, getUser(fr.getSenderId()), getUser(fr.getReceiverId())))
                .toList();
    }

    private void requirePending(FriendRequest friendRequest) {
        if (friendRequest.getFriendRequestStatus() != FriendRequestStatus.PENDING) {
            throw new InvalidFriendRequestActionException(
                    "This request has already been " + friendRequest.getFriendRequestStatus().name().toLowerCase());
        }
    }

    private void linkAsFriends(String userIdA, String userIdB) {
        Seeker seekerA = seekerRepository.findByUserId(userIdA).orElse(null);
        Seeker seekerB = seekerRepository.findByUserId(userIdB).orElse(null);

        if (seekerA != null && !seekerA.getFriendIds().contains(userIdB)) {
            seekerA.getFriendIds().add(userIdB);
            seekerRepository.save(seekerA);
        }
        if (seekerB != null && !seekerB.getFriendIds().contains(userIdA)) {
            seekerB.getFriendIds().add(userIdA);
            seekerRepository.save(seekerB);
        }
    }

    private User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No user found with id: " + userId));
    }

    private FriendRequest getRequestOrThrow(String requestId) {
        return friendRequestRepository.findById(requestId)
                .orElseThrow(() -> new FriendRequestNotFoundException("No friend request found with id: " + requestId));
    }

    private FriendRequestResponse toResponse(FriendRequest friendRequest, User sender, User receiver) {
        return new FriendRequestResponse(
                friendRequest.getRequestId(),
                sender.getId(),
                sender.getProfile() != null ? sender.getProfile().getName() : null,
                receiver.getId(),
                receiver.getProfile() != null ? receiver.getProfile().getName() : null,
                friendRequest.getMessage(),
                friendRequest.getFriendRequestStatus(),
                friendRequest.getCreatedAt()
        );
    }
}
