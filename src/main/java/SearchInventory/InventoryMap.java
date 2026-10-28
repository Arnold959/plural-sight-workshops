package SearchInventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryMap {

    // HashMap to store products
    static HashMap<String, InventoryProduct> inventory = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Load products from CSV file
        loadInventory();

        String answer = "yes";

        // Allow user to search again
        while (answer.equalsIgnoreCase("yes")) {

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            searchProduct(name);

            System.out.print("Do you want to search again? (yes/no): ");
            answer = scanner.nextLine();
        }

        System.out.println("Thank you for using the inventory application!");

        scanner.close();
    }

    // Method to load products from CSV file
    public static void loadInventory() {

        try {

            File file = new File("src/main/java/SearchInventory/inventory.csv");

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                // Split the line using |
                String[] data = line.split("\\|");

                // Check if the line contains 3 values
                if (data.length == 3) {

                    InventoryProduct product = new InventoryProduct();

                    product.id = data[0];
                    product.name = data[1];
                    product.price = Double.parseDouble(data[2]);

                    // Add product to HashMap
                    inventory.put(product.id, product);

                } else {
                    System.out.println("Invalid product: " + line);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Inventory not found!");
        }
    }

    // Method to search for products by name
    public static void searchProduct(String name) {

        boolean found = false;

        for (InventoryProduct product : inventory.values()) {

            if (product.name.equalsIgnoreCase(name)) {

                System.out.println("\nProduct found!");
                System.out.println("ID: " + product.id);
                System.out.println("Name: " + product.name);
                System.out.println("Price: $" + product.price);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found!");
        }
    }
}

// Product class
class InventoryProduct {

    String id;
    String name;
    double price;
}
