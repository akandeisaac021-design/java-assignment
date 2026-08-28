package africa.semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import africa.semicolon.noStrings.data.enums.Gender;

import java.time.LocalDate;
import java.time.Period;

/**
 * Public-facing details about a User: name, gender and date of birth.
 * Kept separate from {@link User} so auth concerns (email/password) stay
 * apart from profile/display concerns.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dob;

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        if (dob == null) {
            return 0;
        }
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
