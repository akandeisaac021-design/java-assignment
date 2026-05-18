import java.util.ArrayList;
import java.util.List;

public class UserRepository{
    private List<User> database = new ArrayList<>();

    public void save(User user){
        database.add(user);
    }

    public User findById(String id){
        for (User user : database){
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    public User findByEmail(String email){
        for (User user : database){
            if (user.getEmail().equalsIgnoreCase(email)) return user;
        }
        return null;
    }
}

