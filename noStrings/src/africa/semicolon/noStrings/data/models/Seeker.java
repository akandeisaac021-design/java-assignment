package semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.repositories.FriendRequestRepositoryImpl;

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
    private Preference preference;

    private FriendRequestRepositoryImpl repo =new FriendRequestRepositoryImpl();
    private FriendRequest friendRequest =new FriendRequest();

    public void getFriendRequestStatus() {
        repo.searchForRequestById(friendRequest.getRequestId());
        Thensettoupdatedstatus();
    }
}


