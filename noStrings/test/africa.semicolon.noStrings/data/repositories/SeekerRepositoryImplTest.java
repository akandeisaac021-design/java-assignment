package data.repositories;

import semicolon.noStrings.data.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.noStrings.data.models.Seeker;
import semicolon.noStrings.data.repositories.SeekerRepository;
import semicolon.noStrings.data.repositories.SeekerRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeekerRepositoryImplTest {

    private SeekerRepository seekerRepository;

    @BeforeEach
    void setUp() {
        seekerRepository = new SeekerRepositoryImpl();
    }

    private Seeker buildSeeker(String userId, Gender gender) {
        Seeker seeker = new Seeker();
        seeker.setGender(gender);
        seeker.setDob(LocalDate.of(1995, 6, 15));
        return seeker;
    }

    @Test
    void testSave_assignsIdToNewSeeker() {
        Seeker seeker = buildSeeker("Ada123", Gender.FEMALE);

        Seeker saved = seekerRepository.save(seeker);

        assertNotNull(saved, "Saved Seeker should not be null");
        assertEquals(1, saved.getId(), "Saved Seeker should have an id assigned");
    }

    @Test
    void testSave_assignsUniqueIdsToMultipleSeekers() {
        Seeker first  = seekerRepository.save(buildSeeker("Ada123",   Gender.FEMALE));
        Seeker second = seekerRepository.save(buildSeeker("Emeka99", Gender.MALE));

        assertNotEquals(first.getId(), second.getId(),
                "Two different Seekers must not share the same id");
    }

    @Test
    void testSave_newSeeker_increasesCount() {
        assertEquals(0, seekerRepository.count(), "Repository should start empty");

        seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        assertEquals(1, seekerRepository.count(), "Count should be 1 after saving one Seeker");
    }

    @Test
    void testSave_existingSeeker_updatesStoredData() {
        Seeker saved = seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        saved.setInterests("Reading, Swimming");
        seekerRepository.save(saved);

        Seeker updated = seekerRepository.findById(saved.getId());
        assertNotNull(updated, "save() should return the updated Seeker");
        assertEquals("Reading, Swimming", updated.getInterests(),
                "Interests should reflect the update");
    }

    @Test
    void testSave_existingSeeker_doesNotIncreaseCount() {
        Seeker saved = seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        saved.setInterests("Cooking");
        seekerRepository.save(saved);

        assertEquals(1, seekerRepository.count(),
                "Count should remain 1 after updating via save()");
    }

    @Test
    void testSave_existingSeeker_oldDataIsNoLongerStored() {
        Seeker saved = seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));
        int id = saved.getId();

        saved.setUserId("NewAdaID");
        seekerRepository.save(saved);

        assertEquals("NewAdaID", seekerRepository.findById(id).getUserId(),
                "findById() should return the updated userId, not the old one");
    }

    // ============================ findById() ============================ //
    @Test
    void testFindById_returnsSavedSeeker() {
        Seeker saved = seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        Seeker found = seekerRepository.findById(saved.getId());

        assertNotNull(found, "Should find the Seeker that was saved");
        assertEquals(saved.getId(), found.getId(), "Id should match");
        assertEquals(saved.getUserId(), found.getUserId(), "UserId should match");
    }

    @Test
    void testFindById_returnsNullForNonExistentId() {
        Seeker found = seekerRepository.findById(999);
        assertNull(found, "Should return null when no Seeker has the given id");
    }

    // ============================= findAll() ============================ //
    @Test
    void testFindAll_returnsEmptyListWhenNoSeekersExist() {
        List<Seeker> all = seekerRepository.findAll();

        assertNotNull(all, "findAll() should never return null");
        assertTrue(all.isEmpty(), "List should be empty when no Seekers have been saved");
    }

    @Test
    void testFindAll_returnsAllSavedSeekers() {
        seekerRepository.save(buildSeeker("Ada123",   Gender.FEMALE));
        seekerRepository.save(buildSeeker("Emeka99", Gender.MALE));

        List<Seeker> all = seekerRepository.findAll();

        assertEquals(2, all.size(), "findAll() should return every saved Seeker");
    }

    @Test
    void testFindAll_returnsDefensiveCopy() {
        seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        List<Seeker> all = seekerRepository.findAll();
        all.clear();

        assertEquals(1, seekerRepository.count(),
                "Clearing the returned list should NOT affect the repository data store");
    }

    @Test
    void testDeleteById_removesSeeker() {
        Seeker saved = seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        seekerRepository.deleteById(saved.getId());

        assertNull(seekerRepository.findById(saved.getId()),
                "Deleted Seeker should no longer be retrievable");
    }

    @Test
    void testDeleteById_decreasesCount() {
        Seeker saved = seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));
        seekerRepository.save(buildSeeker("Emeka99", Gender.MALE));

        seekerRepository.deleteById(saved.getId());

        assertEquals(1, seekerRepository.count(),
                "Count should drop to 1 after deleting one of two Seekers");
    }

    @Test
    void testDeleteById_doesNothingForNonExistentId() {
        seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));

        assertDoesNotThrow(() -> seekerRepository.deleteById(999),
                "deleteById() should not throw when the id does not exist");

        assertEquals(1, seekerRepository.count(),
                "Existing Seekers should be unaffected by a deletion attempt of a non-existent id");
    }

    @Test
    void testDeleteAll_removesAllSeekers() {
        seekerRepository.save(buildSeeker("Ada123", Gender.FEMALE));
        seekerRepository.save(buildSeeker("Emeka99", Gender.MALE));

        seekerRepository.deleteAll();

        assertEquals(0, seekerRepository.count(), "Count should be 0 after deleteAll()");
        assertTrue(seekerRepository.findAll().isEmpty(), "findAll() should return an empty list");
    }

    @Test
    void testDeleteAll_onEmptyRepository() {
        assertDoesNotThrow(() -> seekerRepository.deleteAll(),
                "Calling deleteAll on an empty repository should not throw an exception");
        assertEquals(0, seekerRepository.count());
    }
}
