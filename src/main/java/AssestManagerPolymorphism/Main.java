package AssestManagerPolymorphism;


import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create an ArrayList to store assets
        ArrayList<Asset> myAssets = new ArrayList<>();

        // Create the first house
        House house1 = new House(
                "My house",
                "2020-05-10",
                new BigDecimal("250000"),
                "123 Main Street",
                1,
                2000,
                5000
        );

        // Create the second house
        House house2 = new House(
                "Vacation home",
                "2022-06-15",
                new BigDecimal("180000"),
                "456 Lake Road",
                2,
                1500,
                3000
        );

        // Create the first vehicle
        Vehicle vehicle1 = new Vehicle(
                "My car",
                "2023-03-20",
                new BigDecimal("30000"),
                "Toyota Camry",
                2022,
                60000
        );

        // Create the second vehicle
        Vehicle vehicle2 = new Vehicle(
                "Tom's truck",
                "2021-08-12",
                new BigDecimal("40000"),
                "Ford F150",
                2018,
                120000
        );

        // Add houses and vehicles to the same ArrayList
        myAssets.add(house1);
        myAssets.add(house2);
        myAssets.add(vehicle1);
        myAssets.add(vehicle2);

        // Loop through all assets
        for (Asset asset : myAssets) {

            System.out.println("-------------------------");

            // Display shared asset information
            System.out.println("Description: "
                    + asset.getDescription());

            System.out.println("Date Acquired: "
                    + asset.getDateAcquired());

            System.out.println("Original Cost: $"
                    + asset.getOriginalCost());

            // Polymorphism:
            // Java calls the correct getValue() method
            System.out.printf("Current Value: $%.2f%n",
                    asset.getValue());

            // Check if the asset is a house
            if (asset instanceof House) {

                // Convert Asset to House
                House house = (House) asset;

                System.out.println("Address: "
                        + house.getAddress());

            } else if (asset instanceof Vehicle) {

                // Convert Asset to Vehicle
                Vehicle vehicle = (Vehicle) asset;

                System.out.println("Vehicle: "
                        + vehicle.getYear() + " "
                        + vehicle.getMakeModel());
            }
        }
    }
}

