package data.repositories;

import data.models.Booking;
import data.models.Guest;
import data.models.Room;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository {

    List<Booking> findByGuest(Guest guest);

    List<Booking> findByRoom(Room room);

    List<Booking> findByStatus(String status);

    List<Booking> findByRoomAndStatusNotAndCheckInDateLessThanAndCheckOutDateGreaterThan(
            Room room,
            String excludedStatus,
            LocalDate checkOut,
            LocalDate checkIn
    );
}
