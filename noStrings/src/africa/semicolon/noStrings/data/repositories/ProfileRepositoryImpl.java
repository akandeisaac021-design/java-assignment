package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileRepositoryImpl implements ProfileRepository {

    private static final List<Profile> profileDatabase = new ArrayList<>();

    @Override
    public void save(Profile profile) {
        if (profile == null) {
            return;
        }

        if (profile.getId() != null && !profile.getId().isEmpty()) {
            for (int index = 0; index < profileDatabase.size(); index++) {
                if (profileDatabase.get(index).getId().equals(profile.getId())) {
                    profileDatabase.set(index, profile);
                    return;
                }
            }
        }

        profileDatabase.add(profile);
    }

    @Override
    public void searchForMatches(Gender gender, int minAge, int maxAge) {
        boolean matchFound = false;
        List<Profile> searchResponse = new ArrayList<>();

        for (Profile profile : profileDatabase){
            if (profile.getGender() == gender && profile.getAge() >= minAge && profile.getAge() <= maxAge) {

                searchResponse.add(profile);
            }
        }

        if (!matchFound) {
            System.out.println("No matching profiles found.");
        }
    }

    @Override
    public void deleteAll() {
        profileDatabase.clear();
    }

    public int count() {
        return profileDatabase.size();
    }
}
