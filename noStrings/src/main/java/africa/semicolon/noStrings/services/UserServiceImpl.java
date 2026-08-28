package africa.semicolon.noStrings.services;

import africa.semicolon.noStrings.data.models.Preference;
import africa.semicolon.noStrings.data.models.Profile;
import africa.semicolon.noStrings.data.models.Seeker;
import africa.semicolon.noStrings.data.models.User;
import africa.semicolon.noStrings.data.repositories.SeekerRepository;
import africa.semicolon.noStrings.data.repositories.UserRepository;
import africa.semicolon.noStrings.dtos.requests.RegisterUserRequest;
import africa.semicolon.noStrings.dtos.responses.RegisterUserResponse;
import africa.semicolon.noStrings.exceptions.DuplicateUserException;
import africa.semicolon.noStrings.exceptions.InvalidAgeException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserServiceImpl implements UserService {

    private static final int MINIMUM_AGE = 18;

    private final UserRepository userRepository;
    private final SeekerRepository seekerRepository;

    public UserServiceImpl(UserRepository userRepository, SeekerRepository seekerRepository) {
        this.userRepository = userRepository;
        this.seekerRepository = seekerRepository;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        validateAge(request.getDob());

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateUserException("A user with email '" + request.getEmail() + "' already exists");
        }

        Profile profile = new Profile();
        profile.setFirstName(request.getFirstName());
        profile.setLastName(request.getLastName());
        profile.setGender(request.getGender());
        profile.setDob(request.getDob());

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setProfile(profile);
        User savedUser = userRepository.save(user);
        profile.setUserId(savedUser.getId());

        // Every registered User also gets a Seeker profile (their
        // match-preference + friend list), matching the original design.
        Seeker seeker = new Seeker();
        seeker.setUserId(savedUser.getId());
        seeker.setPreference(new Preference());
        Seeker savedSeeker = seekerRepository.save(seeker);

        return new RegisterUserResponse(
                savedUser.getId(),
                savedSeeker.getId(),
                savedUser.getEmail(),
                profile.getName(),
                "Registration successful"
        );
    }

    private void validateAge(LocalDate dob) {
        int age = Period.between(dob, LocalDate.now()).getYears();
        if (age < MINIMUM_AGE) {
            throw new InvalidAgeException("You must be at least " + MINIMUM_AGE + " years old to register");
        }
    }
}
