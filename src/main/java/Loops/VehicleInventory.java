package Loops;


import java.util.Scanner;

public class VehicleInventory {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array to store 20 vehicles
        Vehicle[] cars = new Vehicle[20];

        // Add 6 vehicles
        cars[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        cars[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        cars[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        cars[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        cars[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        cars[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        int count = 6;
        int choice = 0;

        // Menu
        while (choice != 4) {

            System.out.println("\n=== Vehicle Inventory ===");
            System.out.println("1. View Vehicles");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Add Vehicle");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            if (choice == 1) {

                // Display vehicles
                for (int i = 0; i < count; i++) {
                    cars[i].display();
                }

            } else if (choice == 2) {

                // Search by ID
                System.out.print("Enter Vehicle ID: ");
                long id = input.nextLong();

                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (cars[i].getVehicleId() == id) {
                        cars[i].display();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Vehicle not found");
                }

            } else if (choice == 3) {

                // Add a vehicle
                if (count < 20) {

                    System.out.print("Enter ID: ");
                    long id = input.nextLong();
                    input.nextLine();

                    System.out.print("Enter Make/Model: ");
                    String model = input.nextLine();

                    System.out.print("Enter Color: ");
                    String color = input.nextLine();

                    System.out.print("Enter Mileage: ");
                    int mileage = input.nextInt();

                    System.out.print("Enter Price: ");
                    double price = input.nextDouble();

                    cars[count] = new Vehicle(id, model, color, mileage, price);
                    count++;

                    System.out.println("Vehicle added!");

                } else {
                    System.out.println("Inventory is full!");
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}

// Vehicle class in the same file
class Vehicle {

    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private double price;

    // Constructor
    public Vehicle(long id, String model, String carColor,
                   int mileage, double carPrice) {

        vehicleId = id;
        makeModel = model;
        color = carColor;
        odometerReading = mileage;
        price = carPrice;
    }

    // Getters and setters
    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long id) {
        vehicleId = id;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String model) {
        makeModel = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String carColor) {
        color = carColor;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int mileage) {
        odometerReading = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double carPrice) {
        price = carPrice;
    }

    // Display vehicle information
    public void display() {
        System.out.println(vehicleId + " | " + makeModel
                + " | " + color + " | " + odometerReading
                + " miles | $" + price);
    }
}
