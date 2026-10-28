package SearchInventory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> inventory = getInventory();

        int choice = 0;

        // Keep showing menu until user quits
        while (choice != 5) {

            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - List all products");
            System.out.println("2 - Lookup a product by its ID");
            System.out.println("3 - Find products within a price range");
            System.out.println("4 - Add a new product");
            System.out.println("5 - Quit the application");

            System.out.print("Enter command: ");
            choice = scanner.nextInt();

            // List all products
            if (choice == 1) {

                // Sort products by name
                Collections.sort(inventory,
                        Comparator.comparing(Product::getName));

                System.out.println("\n=== STORE INVENTORY ===");

                for (Product product : inventory) {
                    product.displayProduct();
                }

            }

            // Search product by ID
            else if (choice == 2) {

                System.out.print("Enter product ID: ");
                int searchId = scanner.nextInt();

                boolean found = false;

                for (Product product : inventory) {

                    if (product.id == searchId) {
                        System.out.println("Product found:");
                        product.displayProduct();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product not found.");
                }
            }

            // Search by price range
            else if (choice == 3) {

                System.out.print("Enter minimum price: ");
                double minPrice = scanner.nextDouble();

                System.out.print("Enter maximum price: ");
                double maxPrice = scanner.nextDouble();

                boolean found = false;

                for (Product product : inventory) {

                    if (product.price >= minPrice &&
                            product.price <= maxPrice) {

                        product.displayProduct();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No products found.");
                }
            }

            // Add a new product
            else if (choice == 4) {

                Product newProduct = new Product();

                System.out.print("Enter product ID: ");
                newProduct.id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter product name: ");
                newProduct.name = scanner.nextLine();

                System.out.print("Enter product price: ");
                newProduct.price = scanner.nextDouble();

                inventory.add(newProduct);

                System.out.println("Product added successfully!");
            }

            // Quit application
            else if (choice == 5) {
                System.out.println("Goodbye!");
            }

            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Method to create inventory
    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<>();

        Product product1 = new Product();
        product1.id = 4567;
        product1.name = "10' 2x4 (grade B)";
        product1.price = 9.99;
        inventory.add(product1);

        Product product2 = new Product();
        product2.id = 1234;
        product2.name = "Hammer";
        product2.price = 19.49;
        inventory.add(product2);

        Product product3 = new Product();
        product3.id = 2345;
        product3.name = "Box of nails";
        product3.price = 9.29;
        inventory.add(product3);

        Product product4 = new Product();
        product4.id = 3456;
        product4.name = "Screwdriver";
        product4.price = 5.99;
        inventory.add(product4);

        Product product5 = new Product();
        product5.id = 5678;
        product5.name = "Drill";
        product5.price = 49.99;
        inventory.add(product5);

        return inventory;
    }
}

// Product class
class Product {

    int id;
    String name;
    double price;

    // Method to get product name
    public String getName() {
        return name;
    }

    // Method to display product
    public void displayProduct() {
        System.out.println(id + " | " + name + " | $" + price);
    }
}
