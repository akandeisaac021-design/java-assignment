package africa.semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import africa.semicolon.noStrings.data.enums.BodyType;
import africa.semicolon.noStrings.data.enums.Complexion;
import africa.semicolon.noStrings.data.enums.Gender;

/**
 * What a Seeker is looking for in a match. Not used by the friend-request
 * flow yet, but kept for the matching/search feature this was built for.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preference {

    private Complexion complexion;
    private Gender gender;
    private BodyType bodyType;
}
