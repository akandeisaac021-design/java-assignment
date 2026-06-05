package data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import semicolon.noStrings.data.models.Profile;
import semicolon.noStrings.data.models.User;
import semicolon.noStrings.data.repositories.UserRepository;
import semicolon.noStrings.data.repositories.UserRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    public class UserRepositoryImplTest {

        private UserRepository userRepository;
        private User testProfile;

        @BeforeEach
        public void setUp(){
            userRepository = new UserRepositoryImpl();
            userRepository.deleteAll();

            Profile profile = new Profile();
            profile.setFirstName("Jane");
            profile.setLastName("Doe");

            testProfile = new User();
            testProfile.setEmail("jane.doe@example.com");
            testProfile.setPassword("securePassword123");;
            testProfile.setProfile(profile);
        }

        @Test
        public void testSaveUser_GeneratesId(){
            User savedUser = userRepository.save(testProfile);

            savedUser.setId("U002");
            assertNotNull(savedUser.getId());
            assertEquals(1, userRepository.count());
        }

        @Test
        public void testFindById_ReturnsUser() {
            User savedUser = userRepository.save(testProfile);
            UserRepositoryImpl newRepo =new UserRepositoryImpl();
            savedUser.setId("U002");
            newRepo.save(savedUser);

            assertEquals(savedUser, newRepo.findById(savedUser.getId()));
        }

        @Test
        public void testFindByEmail_ReturnsUserAndIsCaseInsensitive() {
            userRepository.save(testProfile);

            User savedUser = userRepository.save(testProfile);
            User foundUser = userRepository.findByEmail("JANE.DOE@example.com");

            assertEquals(savedUser, foundUser);
        }

        @Test
        public void testUpdateUser_DoesNotCreateNewRecord() {
            User savedUser = userRepository.save(testProfile);
            savedUser.setPassword("newPassword456");
            userRepository.save(savedUser);
            assertEquals(1, userRepository.count());

            userRepository.save(savedUser);
        }

        @Test
        public void testFindAll_ReturnsAllSavedUsers() {
            userRepository.save(testProfile);

            User secondUser = new User(null, "alex@example.com", "pass", null);
            userRepository.save(secondUser);

            List<User> allUsers = userRepository.findAll();
            assertEquals(2, allUsers.size());
        }

        @Test
        public void testDeleteById_RemovesUser() {
            User savedUser = userRepository.save(testProfile);
            assertEquals(1, userRepository.count());

            userRepository.deleteById(savedUser.getId());

            assertEquals(0, userRepository.count());
            assertFalse(savedUser.getId().equals(userRepository.findById(savedUser.getId())) );
        }
    }

