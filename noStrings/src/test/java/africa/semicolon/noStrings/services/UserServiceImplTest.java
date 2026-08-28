package africa.semicolon.noStrings.services;

import africa.semicolon.noStrings.data.enums.Gender;
import africa.semicolon.noStrings.data.repositories.SeekerRepository;
import africa.semicolon.noStrings.data.repositories.SeekerRepositoryImpl;
import africa.semicolon.noStrings.data.repositories.UserRepository;
import africa.semicolon.noStrings.data.repositories.UserRepositoryImpl;
import africa.semicolon.noStrings.dtos.requests.RegisterUserRequest;
import africa.semicolon.noStrings.dtos.responses.RegisterUserResponse;
import africa.semicolon.noStrings.exceptions.DuplicateUserException;
import africa.semicolon.noStrings.exceptions.InvalidAgeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepositoryImpl();
        SeekerRepository seekerRepository = new SeekerRepositoryImpl();
        userService = new UserServiceImpl(userRepository, seekerRepository);
    }

    @Test
    void registeringAdultUser_createsUserAndSeeker() {
        RegisterUserRequest request = new RegisterUserRequest(
                "jane@example.com", "password123", "Jane", "Doe", Gender.FEMALE, LocalDate.of(1998, 5, 21));

        RegisterUserResponse response = userService.register(request);

        assertNotNull(response.getUserId());
        assertNotNull(response.getSeekerId());
        assertEquals("Jane Doe", response.getFullName());
    }

    @Test
    void registeringUnderageUser_throws() {
        RegisterUserRequest request = new RegisterUserRequest(
                "kid@example.com", "password123", "Kid", "Doe", Gender.MALE, LocalDate.now().minusYears(10));

        assertThrows(InvalidAgeException.class, () -> userService.register(request));
    }

    @Test
    void registeringWithDuplicateEmail_throws() {
        RegisterUserRequest request = new RegisterUserRequest(
                "dupe@example.com", "password123", "Jane", "Doe", Gender.FEMALE, LocalDate.of(1998, 5, 21));
        userService.register(request);

        RegisterUserRequest duplicate = new RegisterUserRequest(
                "dupe@example.com", "otherPass", "Someone", "Else", Gender.MALE, LocalDate.of(1990, 1, 1));

        assertThrows(DuplicateUserException.class, () -> userService.register(duplicate));
    }
}
