package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.Seeker;
import java.util.List;

public interface SeekerRepository {

    Seeker save(Seeker seeker);

    Seeker findById(int id);

    List<Seeker> findAll();

    void deleteById(int id);

    void deleteAll();

    int count();
}
