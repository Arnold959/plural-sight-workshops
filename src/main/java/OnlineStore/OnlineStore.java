package OnlineStore;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.IOException;


public class OnlineStore {

    static Scanner scanner = new Scanner(System.in);

    // Store products and shopping cart
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {

        loadProducts();

        int choice = 0;

        while (choice != 3) {

            System.out.println("\n=== ONLINE STORE ===");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                displayProducts();
            } else if (choice == 2) {
                displayCart();
            } else if (choice == 3) {
                System.out.println("Thank you for shopping!");
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    // Read products from CSV file
    public static void loadProducts() {

        try {
            File file = new File("src/main/java/OnlineStore/products.csv");
            Scanner fileScanner = new Scanner(file);

            // Skip header
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] data = line.split("\\|");

                if (data.length == 4) {

                    String sku = data[0];
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    String department = data[3];

                    Product product = new Product(
                            sku, name, price, department);

                    products.add(product);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Products file not found.");
        }
    }

    // Display products menu
    public static void displayProducts() {

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n=== PRODUCTS ===");

            for (Product product : products) {
                product.displayProduct();
            }

            System.out.println("\n1. Search by Name");
            System.out.println("2. Search by Price Range");
            System.out.println("3. Search by Department");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Back to Home");
            System.out.print("Choose an option: ");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                searchByName();
            } else if (choice == 2) {
                searchByPrice();
            } else if (choice == 3) {
                searchByDepartment();
            } else if (choice == 4) {
                addToCart();
            } else if (choice == 5) {
                displayCart();
            } else if (choice != 6) {
                System.out.println("Invalid option.");
            }
        }
    }

    // Search by product name
    public static void searchByName() {

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        for (Product product : products) {

            if (product.name.toLowerCase()
                    .contains(name.toLowerCase())) {
                product.displayProduct();
            }
        }
    }

    // Search by price range
    public static void searchByPrice() {

        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        for (Product product : products) {

            if (product.price >= min &&
                    product.price <= max) {
                product.displayProduct();
            }
        }
    }

    // Search by department
    public static void searchByDepartment() {

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        for (Product product : products) {

            if (product.department.equalsIgnoreCase(department)) {
                product.displayProduct();
            }
        }
    }

    // Add product to shopping cart
    public static void addToCart() {

        System.out.print("Enter product SKU: ");
        String sku = scanner.nextLine();

        for (Product product : products) {

            if (product.sku.equalsIgnoreCase(sku)) {
                cart.add(product);
                System.out.println("Product added to cart!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Display shopping cart

    public static void displayCart() {

        int choice = 0;

        while (choice != 3) {

            double total = 0;

            System.out.println("\n=== SHOPPING CART ===");

            if (cart.isEmpty()) {
                System.out.println("Your cart is empty.");
            }

            // Display each product once with quantity
            ArrayList<String> displayed = new ArrayList<>();

            for (Product product : cart) {

                if (!displayed.contains(product.sku)) {

                    int quantity = 0;

                    for (Product item : cart) {
                        if (item.sku.equals(product.sku)) {
                            quantity++;
                        }
                    }

                    System.out.printf(
                            "%s | %s | Qty: %d | $%.2f%n",
                            product.sku,
                            product.name,
                            quantity,
                            product.price * quantity
                    );

                    displayed.add(product.sku);
                }

                total += product.price;
            }

            System.out.printf("Total: $%.2f%n", total);

            System.out.println("\n1. Check Out");
            System.out.println("2. Remove Product");
            System.out.println("3. Back to Home");
            System.out.print("Choose an option: ");

            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                if (!cart.isEmpty()) {
                    checkOut();
                    return;
                } else {
                    System.out.println("Cart is empty.");
                }
            } else if (choice == 2) {
                removeFromCart();
            } else if (choice != 3) {
                System.out.println("Invalid option.");
            }
        }
    }


    // Remove product from cart
    public static void removeFromCart() {

        System.out.print("Enter product SKU to remove: ");
        String sku = scanner.nextLine();

        for (int i = 0; i < cart.size(); i++) {

            if (cart.get(i).sku.equalsIgnoreCase(sku)) {
                cart.remove(i);
                System.out.println("Product removed!");
                return;
            }
        }

        System.out.println("Product not found in cart.");
    }

    public static void checkOut() {

        double total = 0;

        for (Product product : cart) {
            total += product.price;
        }

        System.out.printf("\nTotal Amount: $%.2f%n", total);

        System.out.print("Enter cash payment: $");
        double payment = Double.parseDouble(scanner.nextLine());

        // Check if payment is enough
        if (payment < total) {
            System.out.println("Not enough money.");
            return;
        }

        double change = payment - total;

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String date = now.format(format);

        // Create receipt
        String receipt = "\n=== SALES RECEIPT ===\n";
        receipt += "Order Date: " + now + "\n";
        receipt += "------------------------\n";

        ArrayList<String> displayed = new ArrayList<>();

        for (Product product : cart) {

            if (!displayed.contains(product.sku)) {

                int quantity = 0;

                for (Product item : cart) {
                    if (item.sku.equals(product.sku)) {
                        quantity++;
                    }
                }

                receipt += product.name + " x" + quantity;
                receipt += " = $" +
                        String.format("%.2f", product.price * quantity);
                receipt += "\n";

                displayed.add(product.sku);
            }
        }

        receipt += "------------------------\n";
        receipt += String.format("Sales Total: $%.2f%n", total);
        receipt += String.format("Amount Paid: $%.2f%n", payment);
        receipt += String.format("Change Given: $%.2f%n", change);
        receipt += "Thank you for shopping!\n";

        // Display receipt
        System.out.println(receipt);

        // Save receipt to file
        try {

            File folder = new File("receipts");
            folder.mkdir();

            File file = new File(folder, date + ".txt");

            PrintWriter writer = new PrintWriter(file);
            writer.print(receipt);
            writer.close();

            System.out.println("Receipt saved!");

        } catch (IOException e) {
            System.out.println("Could not save receipt.");
        }

        // Clear cart
        cart.clear();

        System.out.println("Returning to home screen...");
    }
}
