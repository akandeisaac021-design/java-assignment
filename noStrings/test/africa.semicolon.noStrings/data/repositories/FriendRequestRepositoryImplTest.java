package data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.noStrings.data.models.FriendRequest;
import semicolon.noStrings.data.repositories.FriendRequestRepository;
import semicolon.noStrings.data.repositories.FriendRequestRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class FriendRequestRepositoryImplTest {

    private FriendRequestRepository repository;

    @BeforeEach
    void setUp() {
        repository = new FriendRequestRepositoryImpl();
        repository.deleteAll();
    }

    @Test
    void testSaveNewFriendRequest_CanBeFoundById() {
        FriendRequest request = new FriendRequest();
        request.setRequestId("req-111");
        request.setMessage("Hello, let's connect!");

        repository.save(request);
        FriendRequest foundRequest = repository.searchForRequestById("req-111");

        assertNotNull(foundRequest);
        assertEquals("req-111", foundRequest.getRequestId());
        assertEquals("Hello, let's connect!", foundRequest.getMessage());
    }

    @Test
    void testSaveNullFriendRequest_DoesNotModifyDatabase() {
        repository.save(null);
        FriendRequest foundRequest = repository.searchForRequestById("any-id");

        assertNull(foundRequest);
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

        FriendRequest foundRequest = repository.searchForRequestById("req-222");

        assertNotNull(foundRequest);
        assertEquals("Updated Message", foundRequest.getMessage());
    }

    @Test
    void testSearchForRequestById_ReturnsNullWhenNotFound() {
        FriendRequest foundRequest = repository.searchForRequestById("non-existent-id");

        assertNull(foundRequest);
    }

    @Test
    void testDeleteAll_RemovesAllSavedRequests() {
        FriendRequest request1 = new FriendRequest();
        request1.setRequestId("id-1");
        FriendRequest request2 = new FriendRequest();
        request2.setRequestId("id-2");

        repository.save(request1);
        repository.save(request2);

        repository.deleteAll();

        assertNull(repository.searchForRequestById("id-1"));
        assertNull(repository.searchForRequestById("id-2"));
    }
}
