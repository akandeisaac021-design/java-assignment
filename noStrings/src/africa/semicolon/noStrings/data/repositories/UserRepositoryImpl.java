package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static List<User> database = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public User save(User user) {

        for (int index = 0; index < database.size(); index++) {
            if (database.get(index).getId().equals(user.getId())) {
                database.set(index, user);
                return user;
            }
        }

        if (user.getId() == null || user.getId().isEmpty()) {
            idCounter++;
            user.setId("U" + idCounter);
            database.add(user);
            return user;
        }


        database.add(user);
        return user;
    }


    @Override
    public User findById(String id) {
        for (User user : database) {
            if (user.getId() != null && user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : database) {
            if (user.getEmail() != null && user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public void deleteById(String id) {
        database.removeIf(user -> user.getId() != null && user.getId().equals(id));
    }

    @Override
    public int count() {
        return database.size();
    }

    @Override
    public void deleteAll(){  database.clear();}
}
