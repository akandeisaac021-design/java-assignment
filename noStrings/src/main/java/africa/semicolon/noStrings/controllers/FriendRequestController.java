package africa.semicolon.noStrings.controllers;

import africa.semicolon.noStrings.dtos.requests.SendFriendRequestRequest;
import africa.semicolon.noStrings.dtos.responses.FriendRequestResponse;
import africa.semicolon.noStrings.services.FriendRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/noStrings/friend-requests")
public class FriendRequestController {

    private final FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @PostMapping
    public ResponseEntity<FriendRequestResponse> send(@Valid @RequestBody SendFriendRequestRequest request) {
        FriendRequestResponse response = friendRequestService.sendFriendRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{requestId}/accept")
    public ResponseEntity<FriendRequestResponse> accept(@PathVariable String requestId) {
        return ResponseEntity.ok(friendRequestService.acceptFriendRequest(requestId));
    }

    @PostMapping("/{requestId}/decline")
    public ResponseEntity<FriendRequestResponse> decline(@PathVariable String requestId) {
        return ResponseEntity.ok(friendRequestService.declineFriendRequest(requestId));
    }

    @GetMapping
    public ResponseEntity<List<FriendRequestResponse>> findAll() {
        return ResponseEntity.ok(friendRequestService.findAllFriendRequests());
    }

    // GET /api/noStrings/friend-requests/inbox/{userId}  -> requests received by this user
    @GetMapping("/inbox/{userId}")
    public ResponseEntity<List<FriendRequestResponse>> inbox(@PathVariable String userId) {
        return ResponseEntity.ok(friendRequestService.findInbox(userId));
    }
}
