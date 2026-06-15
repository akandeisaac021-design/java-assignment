package semicolon.noStrings.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import semicolon.noStrings.data.enums.Gender;
import semicolon.noStrings.data.repositories.UserRepositoryImpl;
import semicolon.noStrings.services.SeekerServices;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seeker{
    private int id;
    private String userId;
    private String password;
    private LocalDate dob;
    private Gender gender;
    private Preference preference;
    private List<User> friendList;

    private UserRepositoryImpl repo =new UserRepositoryImpl();
    private FriendRequest friendRequest =new FriendRequest();
    SeekerServices seekerServices =new SeekerServices();

    public void acceptFriendRequest (String friendId) {
        seekerServices.acceptFriendRequest();
        User user = repo.findById(friendId);
        friendList.add(user);
    }

    public void declineFriendRequest (String friendId) {
        seekerServices.declineFriendRequest();
        User user = repo.findById(friendId);
        friendList.add(user);
    }

}