package africa.hotelManagement.data.models;

import data.models.Booking;
import data.models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    private Guest guest;
    private Booking mockBooking1;
    private Booking mockBooking2;

    @BeforeEach
    void setUp() {
        guest = new Guest();
        mockBooking1 = new Booking();
        mockBooking2 = new Booking();
    }

    @Test
    void testIdGetterAndSetter() {
        String expectedId = "G-9876";
        guest.setId(expectedId);
        assertEquals(expectedId, guest.getId(), "The ID should match the set value.");
    }

    @Test
    void testFirstNameGetterAndSetter() {
        String expectedFirstName = "Jane";
        guest.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName, guest.getFirstName(), "The first name should match.");
    }

    @Test
    void testLastNameGetterAndSetter() {
        String expectedLastName = "Doe";
        guest.setLastName(expectedLastName);
        assertEquals(expectedLastName, guest.getLastName(), "The last name should match.");
    }

    @Test
    void testEmailGetterAndSetter() {
        String expectedEmail = "jane.doe@example.com";
        guest.setEmail(expectedEmail);
        assertEquals(expectedEmail, guest.getEmail(), "The email should match.");
    }

    @Test
    void testPhoneGetterAndSetter() {
        String expectedPhone = "+1-555-0199";
        guest.setPhone(expectedPhone);
        assertEquals(expectedPhone, guest.getPhone(), "The phone number should match.");
    }

    @Test
    void testBookingsGetterAndSetter() {
        List<Booking> expectedBookings = new ArrayList<>();
        expectedBookings.add(mockBooking1);
        expectedBookings.add(mockBooking2);

        guest.setBookings(expectedBookings);

        assertNotNull(guest.getBookings(), "The bookings list should not be null.");
        assertEquals(2, guest.getBookings().size(), "The bookings list size should be 2.");
        assertEquals(expectedBookings, guest.getBookings(), "The bookings list reference should match.");
    }

    @Test
    void testDefaultConstructor() {
        Guest newGuest = new Guest();
        assertNull(newGuest.getId());
        assertNull(newGuest.getFirstName());
        assertNull(newGuest.getLastName());
        assertNull(newGuest.getBookings());
    }
}
