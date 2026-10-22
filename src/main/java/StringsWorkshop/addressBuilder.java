package StringsWorkshop;

import java.util.Scanner;

public class addressBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder address = new StringBuilder();
        System.out.println("Please provide the following information:");
        //Get the customer's name
        System.out.println("Full Name: ");
        String fullName = scanner.nextLine();
        address.append(fullName).append("\n\n ");
        //Get billing and shipping addresses
        addAddress(scanner, address,"Billing");
        addAddress(scanner, address,"Shipping");
        //Display customer information
        System.out.println("\nCustomer information:");
        System.out.println(address);
        scanner.close();
    }
    //Method to collect and build an address
    private static void addAddress(Scanner scanner, StringBuilder address, String type) {
        System.out.println(type + " Street:");
        String street = scanner.nextLine();
        System.out.println(type + " City:");
        String city = scanner.nextLine();
        System.out.println(type + " State:");
        String state = scanner.nextLine();
        System.out.println(type + " Zip Code:");
        String zip = scanner.nextLine();
        //Build the address
        address.append(type).append("Address:\n");
        address.append(street).append("\n");
        address.append(city).append(", ");
        address.append(state).append(" ");
        address.append(zip).append("\n");
    }
}
