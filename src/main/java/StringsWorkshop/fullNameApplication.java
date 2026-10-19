package StringsWorkshop;

import java.util.Scanner;

public class fullNameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Ask the user for their name
        System.out.print("First Name:");
        String firstName = scanner.nextLine();
        System.out.print("Middle Name:");
        String middleName = scanner.nextLine();
        System.out.print("Last Name:");
        String lastName = scanner.nextLine();
        System.out.print("Suffix:");
        String suffix = scanner.nextLine();
        //call the method to create the full name
        String fullName = createFullName(firstName,middleName,lastName,suffix);
        System.out.println(fullName);
        scanner.close();
    }
    //Method to create the full name
    private static String createFullName(String firstName, String middleName, String lastName, String suffix) {
        String fullName = firstName;
        //Add middle name if provided
        if (middleName != null) {
            fullName += middleName;
        }
        //Add last name
        fullName += lastName;
        //Add suffix if provided
        if (suffix != null) {
            fullName += suffix;
        }
        return fullName;
    }
}
