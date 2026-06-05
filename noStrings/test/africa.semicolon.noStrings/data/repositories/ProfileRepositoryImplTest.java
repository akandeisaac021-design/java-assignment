package data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Profile;
import semicolon.noStrings.data.repositories.ProfileRepositoryImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileRepositoryImplTest{

    private ProfileRepositoryImpl repository;

    @BeforeEach
    public void setUp() {
        repository = new ProfileRepositoryImpl();
        repository.deleteAll();
    }

    @Test
    public void testSaveNewProfile_IncreasesCount() {
        Profile profile = new Profile("P1", "U1", "Jane", "Doe", Gender.FEMALE, LocalDate.of(1998, 5, 21));
        repository.save(profile);

        assertEquals(1, repository.count());
    }

    @Test
    public void testSaveProfileWithExistingId_UpdatesProfile() {
        Profile profile = new Profile("P1", "U1", "Jane", "Doe", Gender.FEMALE, LocalDate.of(1998, 5, 21));
        repository.save(profile);
        assertEquals(1, repository.count());

        Profile updatedProfile = new Profile("P1", "U1", "Janet", "Doe", Gender.FEMALE, LocalDate.of(1998, 5, 21));
        repository.save(updatedProfile);

        assertEquals(1, repository.count());
   }


    @Test
    public void testDeleteAll_ClearsDatabase() {
        Profile profile1 = new Profile("P1", "U1", "John", "Doe", Gender.MALE, LocalDate.of(1998, 5, 21));
        Profile profile2 = new Profile("P2", "U2", "Jane", "Doe", Gender.FEMALE, LocalDate.of(2000, 1, 1));

        repository.save(profile1);
        repository.save(profile2);
        assertEquals(2, repository.count());

        repository.deleteAll();
        assertEquals(0, repository.count());
    }
}
