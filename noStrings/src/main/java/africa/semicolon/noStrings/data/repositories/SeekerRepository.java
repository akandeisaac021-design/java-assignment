package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.Seeker;

import java.util.List;
import java.util.Optional;

public interface SeekerRepository {

    Seeker save(Seeker seeker);

    Optional<Seeker> findById(String id);

    Optional<Seeker> findByUserId(String userId);

    List<Seeker> findAll();

    void deleteById(String id);

    long count();

    void deleteAll();
}
