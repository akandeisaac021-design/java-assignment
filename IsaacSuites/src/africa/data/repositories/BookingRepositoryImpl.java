package data.repositories;

import data.enums.Status;
import data.models.Booking;
import data.models.Guest;
import data.models.Room;

import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    private static final List<Booking> bookingDatabase =new ArrayList<>();

    @Override
    public void save(Booking booking) {
        if (booking == null) return;

        if (booking.getId() != null && !booking.getId().isEmpty()) {
            for (int index = 0; index < bookingDatabase.size(); index++) {
                if (bookingDatabase.get(index).getId().equals(booking.getId())) {
                    bookingDatabase.set(index, booking);

                }
            }
        }
        bookingDatabase.add(booking);
    }

    @Override
    public int findByGuest(Guest guest) {
        int matchFound =0;

        for(Booking booking : bookingDatabase) {
            if(booking.getGuest() ==guest){
                matchFound++;
            }
        }
        if (matchFound ==0) {
            System.out.println("No matching Guests found.");
        }
        return matchFound;
    }

    @Override
    public int findByRoom(Room room) {
        int matchFound =0;

        for(Booking booking : bookingDatabase){
            if(booking.getRoom() ==room){
                matchFound++;
            }
        }
        if (matchFound ==0) {
            System.out.println("No matching Room found.");
        }
        return matchFound;
    }

    @Override
    public int findByStatus(Status status) {
        int matchFound =0;

        for(Booking booking : bookingDatabase){
            if(booking.getStatus() ==status){
                matchFound++;
            }
        }
        if (matchFound ==0) {
            System.out.println("No matching Room found.");
        }
        return matchFound;
    }

    @Override
    public void deleteAll() {
        bookingDatabase.clear();
    }

    public int count() {
        return bookingDatabase.size();
    }
}
