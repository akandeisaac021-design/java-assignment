package africa.semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The "dating" extension of a {@link User}: their match preference and the
 * list of friend ids (accepted connections) they've built up. Linked back
 * to a User by userId rather than embedding the whole User object, so this
 * stays cheap to store and to serialize.
 *
 * NOTE: this model previously reached into repositories/services directly
 * (an AllArgsConstructor field was a live UserRepositoryImpl!). That has
 * been removed - models are now plain data holders. All of that logic now
 * lives in the service layer, where it belongs.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seeker {

    private String id;
    private String userId;
    private Preference preference;
    private List<String> friendIds = new ArrayList<>();
}
