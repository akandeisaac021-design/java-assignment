import java.util.ArrayList;
import java.util.List;

public class ProfileRepository{
    private List<Profile> database =new ArrayList<>();

    public void save(Profile profile){
        database.add(profile);
    }

    public List<Profile> searchForMatches(String gender, int minAge, int maxAge){
        List<Profile> matches =new ArrayList<>();
        for (Profile p : database){
            if (p.getGender().equalsIgnoreCase(gender) && p.getAge() >=minAge && p.getAge() <=maxAge){
                matches.add(p);
            }
        }
        return matches;
    }
}

