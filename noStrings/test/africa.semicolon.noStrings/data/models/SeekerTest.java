package data.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Seeker;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SeekerTest {

    private Seeker seeker;

    @BeforeEach
    void setUp() {
        seeker = new Seeker();
    }

    @Test
    void testConstructorInitializesFieldsCorrectly() {
        assertEquals(seeker.getId(), 0);
        assertNull(seeker.getUserId(), "userId should be null initially");
        assertNull(seeker.getPassword(), "Password should be null initially");
        assertNull(seeker.getInterests(), "Interest should be null initially");
        assertNull(seeker.getDob(), "Date of birth should be null initially");
        assertNull(seeker.getGender(), "Gender should be null initially");
    }

    @Test
    void testSetIdUpdatesId() {
        seeker.setId(99);
        assertEquals(99, seeker.getId());
    }

    @Test
    void testSetUserIdUpdatesUserId() {
        seeker.setUserId("new_user_456");
        assertEquals("new_user_456", seeker.getUserId());
    }

    @Test
    void testSetPasswordUpdatesPassword() {
        seeker.setPassword("newPassword789");
        assertEquals("newPassword789", seeker.getPassword());
    }

    @Test
    void testSetDobUpdatesDateOfBirth() {
        LocalDate birthday = LocalDate.of(2000, 1, 1);
        seeker.setDob(birthday);
        assertEquals(birthday, seeker.getDob());
    }

    @Test
    void testSetGenderUpdatesGender() {
        seeker.setGender(Gender.MALE);
        assertEquals(Gender.MALE, seeker.getGender());

        seeker.setGender(Gender.FEMALE);
        assertEquals(Gender.FEMALE, seeker.getGender());
    }

    @Test
    void testSetInterestsUpdatesInterests() {
        seeker.setInterests("Reading, Swimming");
        assertEquals("Reading, Swimming", seeker.getInterests());
    }
}
