package VehicleInheritance;


public class Main {

    public static void main(String[] args) {

        // Create a Moped object
        Moped slowRide = new Moped();

        // Set Moped properties
        slowRide.setColor("Red");
        slowRide.setNumberOfPassengers(1);
        slowRide.setCargoCapacity(10);
        slowRide.setFuelCapacity(5);

        // Create a Car object
        Car myCar = new Car();

        // Set Car properties
        myCar.setColor("Blue");
        myCar.setNumberOfPassengers(5);
        myCar.setCargoCapacity(100);
        myCar.setFuelCapacity(50);

        // Create a SemiTruck object
        SemiTruck truck = new SemiTruck();

        // Set SemiTruck properties
        truck.setColor("White");
        truck.setNumberOfPassengers(2);
        truck.setCargoCapacity(10000);
        truck.setFuelCapacity(300);

        // Create a Hovercraft object
        Hovercraft hovercraft = new Hovercraft();

        // Set Hovercraft properties
        hovercraft.setColor("Green");
        hovercraft.setNumberOfPassengers(8);
        hovercraft.setCargoCapacity(500);
        hovercraft.setFuelCapacity(150);

        // Display Moped information
        System.out.println("=== Moped ===");
        System.out.println("Color: " + slowRide.getColor());
        System.out.println("Passengers: " + slowRide.getNumberOfPassengers());
        System.out.println("Cargo: " + slowRide.getCargoCapacity());
        System.out.println("Fuel: " + slowRide.getFuelCapacity());

        // Display Car information
        System.out.println("\n=== Car ===");
        System.out.println("Color: " + myCar.getColor());
        System.out.println("Passengers: " + myCar.getNumberOfPassengers());
        System.out.println("Cargo: " + myCar.getCargoCapacity());
        System.out.println("Fuel: " + myCar.getFuelCapacity());

        // Display SemiTruck information
        System.out.println("\n=== SemiTruck ===");
        System.out.println("Color: " + truck.getColor());
        System.out.println("Passengers: " + truck.getNumberOfPassengers());
        System.out.println("Cargo: " + truck.getCargoCapacity());
        System.out.println("Fuel: " + truck.getFuelCapacity());

        // Display Hovercraft information
        System.out.println("\n=== Hovercraft ===");
        System.out.println("Color: " + hovercraft.getColor());
        System.out.println("Passengers: " + hovercraft.getNumberOfPassengers());
        System.out.println("Cargo: " + hovercraft.getCargoCapacity());
        System.out.println("Fuel: " + hovercraft.getFuelCapacity());

    }
}

