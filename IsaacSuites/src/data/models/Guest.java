package data.models;

import java.util.List;

public class Guest{
    private String id;
    private String firstName;
    private String lastName;
    private List<Booking> bookings;

    public Guest(){}

    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getFirstName(){ return firstName; }
    public void setFirstName(String firstName){ this.firstName = firstName; }

    public String getLastName(){ return lastName; }
    public void setLastName(String lastName){ this.lastName = lastName; }

    public List<Booking> getBookings(){ return bookings; }
    public void setBookings(List<Booking> bookings){ this.bookings = bookings; }
}

