package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final List<User> usersDatabase = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public User save(User user) {

        for (int index = 0; index < usersDatabase.size(); index++) {
            if (usersDatabase.get(index).getId().equals(user.getId())) {
                usersDatabase.set(index, user);
                return user;
            }
        }

        if (user.getId() == null || user.getId().isEmpty()) {
            idCounter++;
            user.setId("U" + idCounter);
            usersDatabase.add(user);
            return user;
        }


        usersDatabase.add(user);
        return user;
    }


    @Override
    public User findById(String id) {
        for (User user : usersDatabase) {
            if (user.getId() != null && user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : usersDatabase) {
            if (user.getEmail() != null && user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(usersDatabase);
    }

    @Override
    public void deleteById(String id) {
        usersDatabase.removeIf(user -> user.getId() != null && user.getId().equals(id));
    }

    @Override
    public int count() {
        return usersDatabase.size();
    }

    @Override
    public void deleteAll(){  usersDatabase.clear();}
}