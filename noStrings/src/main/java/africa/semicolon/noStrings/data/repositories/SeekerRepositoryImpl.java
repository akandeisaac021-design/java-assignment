package africa.semicolon.noStrings.data.repositories;

import africa.semicolon.noStrings.data.models.Seeker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SeekerRepositoryImpl implements SeekerRepository {

    private final Map<String, Seeker> seekersById = new ConcurrentHashMap<>();

    @Override
    public Seeker save(Seeker seeker) {
        if (seeker.getId() == null || seeker.getId().isBlank()) {
            seeker.setId("S-" + UUID.randomUUID());
        }
        seekersById.put(seeker.getId(), seeker);
        return seeker;
    }

    @Override
    public Optional<Seeker> findById(String id) {
        return Optional.ofNullable(seekersById.get(id));
    }

    @Override
    public Optional<Seeker> findByUserId(String userId) {
        return seekersById.values().stream()
                .filter(seeker -> seeker.getUserId() != null && seeker.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<Seeker> findAll() {
        return new ArrayList<>(seekersById.values());
    }

    @Override
    public void deleteById(String id) {
        seekersById.remove(id);
    }

    @Override
    public long count() {
        return seekersById.size();
    }

    @Override
    public void deleteAll() {
        seekersById.clear();
    }
}
