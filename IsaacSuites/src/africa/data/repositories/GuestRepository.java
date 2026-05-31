package data.repositories;

import data.models.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestRepository {

    List<Guest> findByLastName(String lastName);

    List<Guest> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Guest> findByBookingsId(String bookingId);
}
