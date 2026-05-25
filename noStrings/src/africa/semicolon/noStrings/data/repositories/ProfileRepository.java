package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.models.Profile;

public interface ProfileRepository {

    default void save(Profile profile){}

    default void searchForMatches(Gender gender, int minAge, int maxAge){}

    default void deleteAll(){}
}
