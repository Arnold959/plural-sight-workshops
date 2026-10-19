package StringsWorkshop;

import java.util.Scanner;

public class fullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  Name:");
        String fullName = scanner.nextLine();
        displayName(fullName);
        scanner.close();
    }
    public static void displayName(String fullName) {
        int firstSpace = fullName.indexOf(" ");
        int lastSpace = fullName.lastIndexOf(" ");
        String firstName = fullName.substring(0, firstSpace);
        String lastName = fullName.substring(lastSpace + 1);
        String middleName ="(none)";
        if (firstSpace != lastSpace) {
            middleName = fullName.substring(firstSpace + 1, lastSpace);
        }
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
    }
}
