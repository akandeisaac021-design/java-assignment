package data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Guest{
    private String id;
    private String firstName;
    private String lastName;
    private List<Booking> bookings;
    private String email;
    private String phone;
}

