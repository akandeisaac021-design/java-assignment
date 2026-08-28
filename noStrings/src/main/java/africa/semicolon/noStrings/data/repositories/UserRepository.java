package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    boolean existsByEmail(String email);

    void deleteById(String id);

    long count();

    void deleteAll();
}
