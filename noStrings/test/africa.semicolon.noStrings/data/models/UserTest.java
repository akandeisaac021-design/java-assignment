package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Profile;
import semicolon.noStrings.data.models.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private Profile profile;

    @BeforeEach
    public void setUp() {
        // Initialize supporting Profile model
        profile = new Profile();
        profile.setId("P001");
        profile.setFirstName("Alice");
        profile.setLastName("Smith");
        profile.setGender(Gender.FEMALE);
        profile.setDob(LocalDate.of(2000, 1, 1));

        // Initialize User model using Lombok's AllArgsConstructor
        user = new User("U001", "alice@example.com", "password123", profile);
    }

    @Test
    public void testGettersAndAllArgsConstructor() {

        assertEquals("U001", user.getId());
        assertEquals("alice@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(profile, user.getProfile());
    }

    @Test
    public void testSettersAndNoArgsConstructor() {
        User emptyUser = new User();

        emptyUser.setId("U002");
        emptyUser.setEmail("bob@example.com");
        emptyUser.setPassword("securePass");
        emptyUser.setProfile(profile);

        assertEquals("U002", emptyUser.getId());
        assertEquals("bob@example.com", emptyUser.getEmail());
        assertEquals("securePass", emptyUser.getPassword());
        assertEquals(profile, emptyUser.getProfile());
    }

    @Test
    public void testForStructuralEquality() { //using this to understand hashCode
        User identicalUser = new User("U001", "alice@example.com", "password123", profile);
        User differentUser = new User("U002", "bob@example.com", "pass", null);
        assertEquals(user, identicalUser);
        assertEquals(user.hashCode(), identicalUser.hashCode());

        assertNotEquals(user, differentUser);
    }

    @Test
    public void testToString() {
        String toStringResult = user.toString();

        // Lombok @Data includes class name and field values in the string representation
        assertTrue(toStringResult.contains("User"));
        assertTrue(toStringResult.contains("alice@example.com"));
        assertTrue(toStringResult.contains("U001"));
    }
}
