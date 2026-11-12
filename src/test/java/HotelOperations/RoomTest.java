package HotelOperations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    // Test checking into an available room
    @Test
    public void testCheckIn() {

        Room room = new Room(2, 139.00, false, false);

        room.checkIn();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());
    }

    // Test checking into an occupied room
    @Test
    public void testCheckInOccupiedRoom() {

        Room room = new Room(2, 139.00, true, true);

        room.checkIn();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    // Test checking into a dirty room
    @Test
    public void testCheckInDirtyRoom() {

        Room room = new Room(2, 139.00, false, true);

        room.checkIn();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    // Test checking out of a room
    @Test
    public void testCheckOut() {

        Room room = new Room(2, 139.00, true, true);

        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());
    }

    // Test cleaning a dirty room
    @Test
    public void testCleanRoom() {

        Room room = new Room(2, 139.00, false, true);

        room.cleanRoom();

        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    // Test cleaning an occupied room
    @Test
    public void testCleanOccupiedRoom() {

        Room room = new Room(2, 139.00, true, true);

        room.cleanRoom();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }
}

