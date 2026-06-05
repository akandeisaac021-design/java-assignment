package data.repositories;

import data.models.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestRepository {

    int findByLastName(String lastName);

    int findByFirstNameAndLastName(String firstName, String lastName);

    int findByBookingsId(String bookingId);
}
