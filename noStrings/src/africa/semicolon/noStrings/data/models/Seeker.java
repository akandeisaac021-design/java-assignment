package semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolon.noStrings.data.enums.Gender;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seeker {
    private int id;
    private String userId;
    private String password;
    private LocalDate dob;
    private Gender gender;
    private String interests;

}


