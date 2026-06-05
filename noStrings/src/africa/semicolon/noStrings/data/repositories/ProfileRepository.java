package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Profile;

public interface ProfileRepository {

    void save(Profile profile);

    void searchForMatches(Gender gender, int minAge, int maxAge);

    void deleteAll();
}
