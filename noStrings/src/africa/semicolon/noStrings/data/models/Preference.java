package semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolon.noStrings.data.enums.BodyType;
import semicolon.noStrings.data.enums.Complexion;
import semicolon.noStrings.data.enums.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preference {

    private Complexion complexion;
    private Gender gender;
    private BodyType bodyType;

}
