package africa.semicolon.noStrings.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An account on the platform. Holds auth details (email/password) and the
 * embedded {@link Profile}. This is the entity friend requests are sent
 * between.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String email;

    @JsonIgnore // never echo the password back in a response
    private String password;

    private Profile profile;
}
