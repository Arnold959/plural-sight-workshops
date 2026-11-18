package AbstactAssestManager;


import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create an ArrayList of Asset objects
        ArrayList<Asset> myAssets = new ArrayList<>();

        // First house
        House house1 = new House(
                "My House",
                "2020-05-10",
                new BigDecimal("250000"),
                "123 Main Street",
                1,
                2000,
                5000
        );

        // Second house
        House house2 = new House(
                "Vacation Home",
                "2022-06-15",
                new BigDecimal("180000"),
                "456 Lake Road",
                2,
                1500,
                3000
        );

        // First vehicle
        Vehicle vehicle1 = new Vehicle(
                "My Car",
                "2023-03-20",
                new BigDecimal("30000"),
                "Toyota Camry",
                2022,
                60000
        );

        // Second vehicle
        Vehicle vehicle2 = new Vehicle(
                "Tom's Truck",
                "2021-08-12",
                new BigDecimal("40000"),
                "Ford F150",
                2018,
                120000
        );

        // Create a Cash object
        Cash cash1 = new Cash(
                "Emergency Savings",
                "2026-01-15",
                new BigDecimal("5000")
        );

        // Add all assets to the ArrayList
        myAssets.add(house1);
        myAssets.add(house2);
        myAssets.add(vehicle1);
        myAssets.add(vehicle2);
        myAssets.add(cash1);

        // Loop through the ArrayList
        for (Asset asset : myAssets) {

            System.out.println("-------------------------");

            // Display common properties
            System.out.println("Description: "
                    + asset.getDescription());

            System.out.println("Date Acquired: "
                    + asset.getDateAcquired());

            System.out.println("Original Cost: $"
                    + asset.getOriginalCost());

            // Polymorphism:
            // Calls the correct getValue() method
            System.out.printf("Current Value: $%.2f%n",
                    asset.getValue());

            // Check whether the asset is a House
            if (asset instanceof House) {

                House house = (House) asset;

                System.out.println("Address: "
                        + house.getAddress());

                // Check whether the asset is a Vehicle
            } else if (asset instanceof Vehicle) {

                Vehicle vehicle = (Vehicle) asset;

                System.out.println("Vehicle: "
                        + vehicle.getYear() + " "
                        + vehicle.getMakeModel());

                // Check whether the asset is Cash
            } else if (asset instanceof Cash) {

                System.out.println("Asset Type: Cash");
            }
        }
    }
}
