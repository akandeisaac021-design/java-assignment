package models;

import data.models;
import data.models.Booking;
import data.models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private Booking booking;
    private Guest mockGuest;
    private models.Room mockRoom;

    @BeforeEach
    void setUp() {
        booking = new Booking();
        mockGuest = new Guest();
        mockRoom = new models.Room();
    }

    @Test
    void testIdGetterAndSetter() {
        String expectedId = "B12345";
        booking.setId(expectedId);
        assertEquals(expectedId, booking.getId(), "The ID should match the set value.");
    }

    @Test
    void testGuestGetterAndSetter() {
        booking.setGuest(mockGuest);
        assertNotNull(booking.getGuest(), "The guest should not be null.");
        assertEquals(mockGuest, booking.getGuest(), "The guest reference should match.");
    }

    @Test
    void testRoomGetterAndSetter() {
        booking.setRoom(mockRoom);
        assertNotNull(booking.getRoom(), "The room should not be null.");
        assertEquals(mockRoom, booking.getRoom(), "The room reference should match.");
    }

    @Test
    void testCheckInDateGetterAndSetter() {
        LocalDate checkIn = LocalDate.of(2026, 6, 1);
        booking.setCheckInDate(checkIn);
        assertEquals(checkIn, booking.getCheckInDate(), "The check-in date should match.");
    }

    @Test
    void testCheckOutDateGetterAndSetter() {
        LocalDate checkOut = LocalDate.of(2026, 6, 7);
        booking.setCheckOutDate(checkOut);
        assertEquals(checkOut, booking.getCheckOutDate(), "The check-out date should match.");
    }

    @Test
    void testTotalAmountGetterAndSetter() {
        Double expectedAmount = 450.50;
        booking.setTotalAmount(expectedAmount);
        assertEquals(expectedAmount, booking.getTotalAmount(), "The total amount should match.");
    }

    @Test
    void testStatusGetterAndSetter() {
        String expectedStatus = "CONFIRMED";
        booking.setStatus(expectedStatus);
        assertEquals(expectedStatus, booking.getStatus(), "The status string should match.");
    }

    @Test
    void testDefaultConstructor() {
        Booking newBooking = new Booking();
        assertNull(newBooking.getId());
        assertNull(newBooking.getGuest());
        assertNull(newBooking.getRoom());
        assertNull(newBooking.getCheckInDate());
        assertNull(newBooking.getCheckOutDate());
        assertNull(newBooking.getTotalAmount());
        assertNull(newBooking.getStatus());
    }
}
