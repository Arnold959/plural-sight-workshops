package HotelOperations;



public class Hotel {

    // Private variables
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // First constructor - starts with no booked rooms
    public Hotel(String name, int numberOfSuites,
                 int numberOfRooms) {

        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Second constructor - starts with booked rooms
    public Hotel(String name, int numberOfSuites,
                 int numberOfRooms, int bookedSuites,
                 int bookedBasicRooms) {

        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Get hotel name
    public String getName() {
        return name;
    }

    // Get total suites
    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    // Get total basic rooms
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    // Get booked suites
    public int getBookedSuites() {
        return bookedSuites;
    }

    // Get booked basic rooms
    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // Calculate available suites
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    // Calculate available basic rooms
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    // Book one or more rooms
    public boolean bookRoom(int roomCount, boolean suite) {

        // Do not allow zero or negative bookings
        if (roomCount <= 0) {
            return false;
        }

        // Check if the customer wants a suite
        if (suite) {

            if (roomCount <= getAvailableSuites()) {
                bookedSuites = bookedSuites + roomCount;
                return true;
            } else {
                return false;
            }

        } else {

            // Check availability of basic rooms
            if (roomCount <= getAvailableRooms()) {
                bookedBasicRooms = bookedBasicRooms + roomCount;
                return true;
            } else {
                return false;
            }
        }
    }
}
