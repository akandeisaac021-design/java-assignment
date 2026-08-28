package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.Profile;
import africa.semicolon.noStrings.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepository userRepository;
    private User testUser;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();

        Profile profile = new Profile();
        profile.setFirstName("Jane");
        profile.setLastName("Doe");

        testUser = new User();
        testUser.setEmail("jane.doe@example.com");
        testUser.setPassword("securePassword123");
        testUser.setProfile(profile);
    }

    @Test
    void testSaveUser_GeneratesId() {
        User savedUser = userRepository.save(testUser);

        assertNotNull(savedUser.getId());
        assertEquals(1, userRepository.count());
    }

    @Test
    void testFindById_ReturnsUser() {
        User savedUser = userRepository.save(testUser);

        assertEquals(savedUser, userRepository.findById(savedUser.getId()).orElse(null));
    }

    @Test
    void testFindByEmail_ReturnsUserAndIsCaseInsensitive() {
        User savedUser = userRepository.save(testUser);
        User foundUser = userRepository.findByEmail("JANE.DOE@example.com").orElse(null);

        assertEquals(savedUser, foundUser);
    }

    @Test
    void testUpdateUser_DoesNotCreateNewRecord() {
        User savedUser = userRepository.save(testUser);
        savedUser.setPassword("newPassword456");
        userRepository.save(savedUser);

        assertEquals(1, userRepository.count());
    }

    @Test
    void testFindAll_ReturnsAllSavedUsers() {
        userRepository.save(testUser);
        userRepository.save(new User(null, "alex@example.com", "pass", null));

        List<User> allUsers = userRepository.findAll();
        assertEquals(2, allUsers.size());
    }

    @Test
    void testDeleteById_RemovesUser() {
        User savedUser = userRepository.save(testUser);
        assertEquals(1, userRepository.count());

        userRepository.deleteById(savedUser.getId());

        assertEquals(0, userRepository.count());
        assertTrue(userRepository.findById(savedUser.getId()).isEmpty());
    }

    @Test
    void testExistsByEmail() {
        userRepository.save(testUser);
        assertTrue(userRepository.existsByEmail("jane.doe@example.com"));
        assertFalse(userRepository.existsByEmail("nope@example.com"));
    }
}
