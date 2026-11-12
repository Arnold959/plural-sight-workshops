package HotelOperations;

public class Main {
    public static void main(String[] args) {
        //Create a hotel room
        Room room1 = new Room(2,139.00,false, false);
        //Display room information
        System.out.println("===ROOM INFORMATION===");
        System.out.println("Number of Beds:"+room1.getNumberOfBeds());
        System.out.println("Room Price: $"+room1.getPrice());
        System.out.println("Occupied: "+room1.isOccupied());
        System.out.println("Dirty:"+room1.isDirty());
        System.out.println("Available:"+room1.isAvailable());

        //Create a reservation
        Reservation reservation1 = new Reservation("king",3,true);
        //Display Reservation information
        System.out.println("\n===RESERVATION INFORMATION===");
        System.out.println("Room Type:"+reservation1.getRoomType());
        System.out.println("Number of nights:"+reservation1.getNumberOfNights());
        System.out.println("Weekend:" + reservation1.isWeekend());
        System.out.println("Price per night: $"+reservation1.getPrice());
        System.out.printf("Reservation Total: $%.2f%n",reservation1.getReservationTotal());

         //Create an employee
         Employee employee1 = new Employee(101,"Arnold Aries","Front Desk",20.00,45);
         System.out.println("\n===EMPLOYEE INFORMATION===");
         System.out.println("Employee ID:"+employee1.getEmployeeId());
         System.out.println("Name:"+employee1.getName());
         System.out.println("Department:"+employee1.getDepartment());
         System.out.println("Pay Rate: $"+employee1.getPayRate());
         System.out.println("Hours Worked" + employee1.getHoursWorked());
         System.out.println("Regular Hours: " + employee1.getRegularHours());
         System.out.println("Overtime Hours: " + employee1.getOvertimeHours());
         System.out.printf("Total pay: $%.2f%n",employee1.getTotalPay());

        //Exercise 2- ROOM TEST
        System.out.println("\n=== ROOM CHECK-IN AND CHECK-OUT ===");
        Room room2 = new Room(2,124.00,false, false);
        System.out.println("Available: "+room2.isAvailable());
        room2.checkIn();

        System.out.println("Occupied: "+room2.isOccupied());
        System.out.println("Dirty: "+room2.isDirty());
        room2.checkOut();

        System.out.println("Available after cleaning: "+room2.isAvailable());

        //Employee Test
        System.out.println("\n====EMPLOYEE TIME CARD===");
        Employee employee2 = new Employee(102,"Jane Doe","Housekeeping",20.00,0);
        employee2.punchIn(9);
        employee2.punchOut(17);

        System.out.println("Total Hours:" + employee2.getHoursWorked());
        System.out.println("Total Pay: $" + employee2.getTotalPay());


        // EXERCISE 3 - METHOD OVERLOADING

        System.out.println("\n=== EMPLOYEE METHOD OVERLOADING ===");

        Employee employee4 = new Employee(104, "James",
                        "Reception", 20.00, 0);

        // Punch in using the current time
        employee4.punchIn();

        // Punch out using the current time
        employee4.punchOut();

        System.out.println("Total Hours: " + employee4.getHoursWorked());



        // EXERCISE 3 - HOTEL TEST

        System.out.println("\n=== HOTEL OPERATIONS ===");

        // Test first constructor
        Hotel hotel1 = new Hotel("Grand Hotel", 5, 10);

        System.out.println("Hotel: " + hotel1.getName());
        System.out.println("Available Suites: " + hotel1.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel1.getAvailableRooms());

        // Book 2 suites
        boolean booking1 = hotel1.bookRoom(2, true);

        System.out.println("Suite Booking Successful: " + booking1);

        // Book 3 basic rooms
        boolean booking2 = hotel1.bookRoom(3, false);

        System.out.println("Basic Room Booking Successful: " + booking2);

        // Display remaining rooms
        System.out.println("Remaining Suites: " + hotel1.getAvailableSuites());
        System.out.println("Remaining Basic Rooms: " + hotel1.getAvailableRooms());


        // Test second constructor
        System.out.println("\n=== SECOND HOTEL ===");

        Hotel hotel2 = new Hotel("City Hotel", 4, 8, 2, 3);

        System.out.println("Hotel: " + hotel2.getName());
        System.out.println("Available Suites: " + hotel2.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel2.getAvailableRooms());

        // Try booking more suites than available
        boolean booking3 = hotel2.bookRoom(3, true);

        System.out.println("Booking Successful: " + booking3);


        //Test the Bonus method
        System.out.println("\n===TIME CARD===");
        Employee employee3 = new Employee(103,"Mary","Reception",20.00,0);
        employee3.punchTimeCard(8,16);
        System.out.println("Total Hours:" + employee3.getHoursWorked());
        System.out.println("Total Pay: $" + employee3.getTotalPay());

    }

}
