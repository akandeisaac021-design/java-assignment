package africa.hotelManagement.data.models;

import data.models.Room;
import org.junit.jupiter.api.Test;

import static data.enums.RoomType.*;
import static data.enums.Status.*;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testNoArgsConstructor() {
        Room room = new Room();

        assertNull(room.getId());
        assertNull(room.getRoomNumber());
        assertNull(room.getRoomType());
        assertNull(room.getPricePerNight());
        assertNull(room.getStatus());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        Room room = new Room("R101", "101", DELUXE, 150.00, VACANT);

        assertEquals("R101", room.getId());
        assertEquals("101", room.getRoomNumber());
        assertEquals(VACANT, room.getRoomType());
        assertEquals(150.00, room.getPricePerNight());
        assertEquals(VACANT, room.getStatus());
    }

    @Test
    void testSetters() {
        Room room = new Room();

        room.setId("R202");
        room.setRoomNumber("202");
        room.setRoomType(SUITE);
        room.setPricePerNight(300.50);
        room.setStatus(OCCUPIED);

        assertEquals("R202", room.getId());
        assertEquals("202", room.getRoomNumber());
        assertEquals(SUITE, room.getRoomType());
        assertEquals(300.50, room.getPricePerNight());
        assertEquals(OCCUPIED, room.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        Room room1 = new Room("R101", "101", DELUXE, 150.00, VACANT);
        Room room2 = new Room("R101", "101", DELUXE, 150.00, VACANT);
        Room room3 = new Room("R102", "102", STANDARD, 85.00, MAINTENANCE);

        // Test equality and symmetry
        assertEquals(room1, room2);
        assertEquals(room1.hashCode(), room2.hashCode());

        // Test inequality
        assertNotEquals(room1, room3);
        assertNotEquals(room1.hashCode(), room3.hashCode());
        assertNotEquals(null, room1);
    }

    @Test
    void testToString() {
        Room room = new Room("R101", "101", DELUXE, 150.00, VACANT);
        String toStringResult = room.toString();

        assertTrue(toStringResult.contains("id=R101"));
        assertTrue(toStringResult.contains("roomNumber=101"));
        assertTrue(toStringResult.contains("pricePerNight=150.0"));
    }
}
