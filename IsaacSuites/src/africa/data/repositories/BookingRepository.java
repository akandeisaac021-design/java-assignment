package data.repositories;

import data.enums.Status;
import data.models.Booking;
import data.models.Guest;
import data.models.Room;


public interface BookingRepository {

    void save(Booking booking);

    int count();

    void deleteAll();

    int findByGuest(Guest guest);

    int findByRoom(Room room);

    int findByStatus(Status status);

}