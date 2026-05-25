package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.User;
import java.util.List;

public interface UserRepository {

    User save(User user);

    User findById(String id);

    User findByEmail(String email);

    List<User> findAll();

    void deleteById(String id);

    int count();

    void deleteAll();
}
