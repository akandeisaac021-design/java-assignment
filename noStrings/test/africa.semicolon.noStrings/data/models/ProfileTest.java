package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.noStrings.data.models.Profile;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static semicolon.noStrings.data.enums.Gender.MALE;

public class ProfileTest {

    private Profile profile;

    @BeforeEach
    public void setUp() {
        LocalDate dateOfBirth = LocalDate.of(1998, 5, 21);
        profile = new Profile("P123", "U456", "John", "Doe", MALE, dateOfBirth);
    }

    @Test
    public void testGetUserId() {
        assertEquals("U456", profile.getUserId());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", profile.getName());
    }

    @Test
    public void testGetGender() {
        assertEquals(MALE, profile.getGender());
    }

    @Test
    public void testGetAge() {
        assertEquals(28, profile.getAge());
    }
}
