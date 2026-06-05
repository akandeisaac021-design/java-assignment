package data.repositories;

import data.models.Booking;
import data.models.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestRepositoryImpl implements GuestRepository{

    private static final List<Guest> guestDatabase =new ArrayList<>();

    @Override
    public int findByLastName(String lastName) {
        int matchFound =0;

        for(Guest guest : guestDatabase) {
            if(guest.getLastName().equals(lastName)){
                matchFound++;
            }
        }
        if (matchFound ==0) {
            System.out.println("No matching Guests found.");
        }
        return matchFound;
    }

    @Override
    public int findByFirstNameAndLastName(String firstName, String lastName) {
        int matchFound =0;

        for(Guest guest : guestDatabase) {
            if(guest.getLastName().equals(lastName) && guest.getFirstName().equals(firstName)){
                matchFound++;
            }
        }
        if (matchFound ==0) {
            System.out.println("No matching Guests found.");
        }
        return matchFound;
    }

    @Override
    public int findByBookingsId(String bookingId) {
        int matchFound =0;

        for(Guest guest : guestDatabase) {
            if(guest.getId().equals(bookingId)){
                matchFound++;
            }
        }
        if (matchFound ==0) {
            System.out.println("No matching Guests found.");
        }
        return matchFound;
    }
}