package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation, good enough for this MVP. Swap for a Spring
 * Data JPA repository later without touching the service layer, since
 * everything talks to the UserRepository interface.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> usersById = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        if (user.getId() == null || user.getId().isBlank()) {
            user.setId("U-" + UUID.randomUUID());
        }
        usersById.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(usersById.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return usersById.values().stream()
                .filter(user -> email.equalsIgnoreCase(user.getEmail()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(usersById.values());
    }

    @Override
    public boolean existsByEmail(String email) {
        return findByEmail(email).isPresent();
    }

    @Override
    public void deleteById(String id) {
        usersById.remove(id);
    }

    @Override
    public long count() {
        return usersById.size();
    }

    @Override
    public void deleteAll() {
        usersById.clear();
    }
}
