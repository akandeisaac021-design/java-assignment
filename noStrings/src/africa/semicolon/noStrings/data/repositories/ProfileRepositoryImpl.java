package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileRepositoryImpl implements ProfileRepository {

    private static final List<Profile> database = new ArrayList<>();

    @Override
    public void save(Profile profile) {
        if (profile == null) return;

        if (profile.getId() != null && !profile.getId().isEmpty()) {
            for (int index = 0; index < database.size(); index++) {
                if (database.get(index).getId().equals(profile.getId())) {
                    database.set(index, profile);
                    return;
                }
            }
        }

        database.add(profile);
    }

    @Override
    public void searchForMatches(Gender gender, int minAge, int maxAge) {
        boolean matchFound = false;

        for (Profile profile : database){
            if (profile.getGender() == gender && profile.getAge() >= minAge && profile.getAge() <= maxAge) {

                matchFound = true;
            }
        }

        if (!matchFound) {
            System.out.println("No matching profiles found.");
        }
    }

    @Override
    public void deleteAll() {
        database.clear();
    }

    public int count() {
        return database.size();
    }
}
