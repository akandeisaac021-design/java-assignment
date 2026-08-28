package africa.semicolon.noStrings.services;

import africa.semicolon.noStrings.data.enums.FriendRequestStatus;
import africa.semicolon.noStrings.data.enums.Gender;
import africa.semicolon.noStrings.data.repositories.FriendRequestRepository;
import africa.semicolon.noStrings.data.repositories.FriendRequestRepositoryImpl;
import africa.semicolon.noStrings.data.repositories.SeekerRepository;
import africa.semicolon.noStrings.data.repositories.SeekerRepositoryImpl;
import africa.semicolon.noStrings.data.repositories.UserRepository;
import africa.semicolon.noStrings.data.repositories.UserRepositoryImpl;
import africa.semicolon.noStrings.dtos.requests.RegisterUserRequest;
import africa.semicolon.noStrings.dtos.requests.SendFriendRequestRequest;
import africa.semicolon.noStrings.dtos.responses.FriendRequestResponse;
import africa.semicolon.noStrings.dtos.responses.RegisterUserResponse;
import africa.semicolon.noStrings.exceptions.InvalidFriendRequestActionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercises the actual MVP flow: two users register, one sends the other a
 * friend request with a message, the receiver accepts it.
 */
class FriendRequestServiceImplTest {

    private UserRepository userRepository;
    private SeekerRepository seekerRepository;
    private FriendRequestRepository friendRequestRepository;
    private UserService userService;
    private FriendRequestService friendRequestService;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        seekerRepository = new SeekerRepositoryImpl();
        friendRequestRepository = new FriendRequestRepositoryImpl();

        userService = new UserServiceImpl(userRepository, seekerRepository);
        friendRequestService = new FriendRequestServiceImpl(friendRequestRepository, userRepository, seekerRepository);
    }

    private RegisterUserResponse registerUser(String email, String firstName) {
        RegisterUserRequest request = new RegisterUserRequest(
                email, "password123", firstName, "Doe", Gender.FEMALE, LocalDate.of(1998, 5, 21));
        return userService.register(request);
    }

    @Test
    void sendFriendRequest_thenAccept_marksRequestAcceptedAndLinksFriends() {
        RegisterUserResponse ada = registerUser("ada@example.com", "Ada");
        RegisterUserResponse emeka = registerUser("emeka@example.com", "Emeka");

        SendFriendRequestRequest sendRequest = new SendFriendRequestRequest(ada.getUserId(), emeka.getUserId(), "Hi, let's connect!");
        FriendRequestResponse sent = friendRequestService.sendFriendRequest(sendRequest);

        assertEquals(FriendRequestStatus.PENDING, sent.getStatus());
        assertEquals("Hi, let's connect!", sent.getMessage());

        FriendRequestResponse accepted = friendRequestService.acceptFriendRequest(sent.getRequestId());

        assertEquals(FriendRequestStatus.ACCEPTED, accepted.getStatus());
        assertTrue(seekerRepository.findByUserId(ada.getUserId()).orElseThrow().getFriendIds().contains(emeka.getUserId()));
        assertTrue(seekerRepository.findByUserId(emeka.getUserId()).orElseThrow().getFriendIds().contains(ada.getUserId()));
    }

    @Test
    void sendFriendRequest_thenDecline_marksRequestDeclined() {
        RegisterUserResponse ada = registerUser("ada2@example.com", "Ada");
        RegisterUserResponse emeka = registerUser("emeka2@example.com", "Emeka");

        FriendRequestResponse sent = friendRequestService.sendFriendRequest(
                new SendFriendRequestRequest(ada.getUserId(), emeka.getUserId(), "Hey there"));

        FriendRequestResponse declined = friendRequestService.declineFriendRequest(sent.getRequestId());

        assertEquals(FriendRequestStatus.DECLINED, declined.getStatus());
        assertFalse(seekerRepository.findByUserId(ada.getUserId()).orElseThrow().getFriendIds().contains(emeka.getUserId()));
    }

    @Test
    void acceptingAnAlreadyAcceptedRequest_throws() {
        RegisterUserResponse ada = registerUser("ada3@example.com", "Ada");
        RegisterUserResponse emeka = registerUser("emeka3@example.com", "Emeka");

        FriendRequestResponse sent = friendRequestService.sendFriendRequest(
                new SendFriendRequestRequest(ada.getUserId(), emeka.getUserId(), "Hey"));
        friendRequestService.acceptFriendRequest(sent.getRequestId());

        assertThrows(InvalidFriendRequestActionException.class,
                () -> friendRequestService.acceptFriendRequest(sent.getRequestId()));
    }

    @Test
    void sendingDuplicatePendingRequest_throws() {
        RegisterUserResponse ada = registerUser("ada4@example.com", "Ada");
        RegisterUserResponse emeka = registerUser("emeka4@example.com", "Emeka");

        friendRequestService.sendFriendRequest(new SendFriendRequestRequest(ada.getUserId(), emeka.getUserId(), "Hey"));

        assertThrows(InvalidFriendRequestActionException.class,
                () -> friendRequestService.sendFriendRequest(new SendFriendRequestRequest(ada.getUserId(), emeka.getUserId(), "Hey again")));
    }

    @Test
    void sendingRequestToSelf_throws() {
        RegisterUserResponse ada = registerUser("ada5@example.com", "Ada");

        assertThrows(InvalidFriendRequestActionException.class,
                () -> friendRequestService.sendFriendRequest(new SendFriendRequestRequest(ada.getUserId(), ada.getUserId(), "Hi me")));
    }
}
