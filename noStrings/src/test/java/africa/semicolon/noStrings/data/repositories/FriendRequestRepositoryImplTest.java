package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.enums.FriendRequestStatus;
import africa.semicolon.noStrings.data.models.FriendRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendRequestRepositoryImplTest {

    private FriendRequestRepository repository;

    @BeforeEach
    void setUp() {
        repository = new FriendRequestRepositoryImpl();
    }

    @Test
    void testSaveNewFriendRequest_CanBeFoundById() {
        FriendRequest request = new FriendRequest();
        request.setMessage("Hello, let's connect!");
        request.setFriendRequestStatus(FriendRequestStatus.PENDING);

        FriendRequest saved = repository.save(request);
        FriendRequest foundRequest = repository.findById(saved.getRequestId()).orElse(null);

        assertNotNull(foundRequest);
        assertEquals("Hello, let's connect!", foundRequest.getMessage());
    }

    @Test
    void testSaveNullFriendRequest_DoesNotModifyDatabase() {
        repository.save(null);
        assertTrue(repository.findById("any-id").isEmpty());
    }

    @Test
    void testSaveFriendRequestWithExistingId_UpdatesExistingRecord() {
        FriendRequest originalRequest = new FriendRequest();
        originalRequest.setRequestId("req-222");
        originalRequest.setMessage("Original Message");
        repository.save(originalRequest);

        FriendRequest updatedRequest = new FriendRequest();
        updatedRequest.setRequestId("req-222");
        updatedRequest.setMessage("Updated Message");
        repository.save(updatedRequest);

        FriendRequest foundRequest = repository.findById("req-222").orElse(null);

        assertNotNull(foundRequest);
        assertEquals("Updated Message", foundRequest.getMessage());
    }

    @Test
    void testFindById_ReturnsEmptyWhenNotFound() {
        assertTrue(repository.findById("non-existent-id").isEmpty());
    }

    @Test
    void testDeleteAll_RemovesAllSavedRequests() {
        FriendRequest request1 = new FriendRequest();
        FriendRequest request2 = new FriendRequest();

        FriendRequest saved1 = repository.save(request1);
        FriendRequest saved2 = repository.save(request2);

        repository.deleteAll();

        assertTrue(repository.findById(saved1.getRequestId()).isEmpty());
        assertTrue(repository.findById(saved2.getRequestId()).isEmpty());
    }
}
