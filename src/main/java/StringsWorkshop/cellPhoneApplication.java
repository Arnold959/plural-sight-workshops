package StringsWorkshop;

import java.util.Scanner;

public class cellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
    // Collect more information
        System.out.print("What is the serial Number: ");
        String serialNumber = scanner.next();
        System.out.print("What is the model of the phone?: ");
        String model = scanner.next();
        System.out.print("Who is the carrier: ");
        String carrier = scanner.next();
        System.out.print("What is the phone number?: ");
        String phoneNumber = scanner.next();
        System.out.print("Who is the owner of the phone?: ");
        String owner = scanner.next();

    //Method to collect phone information
        System.out.print("Enter Serial number: ");
        String serialNumber2 = scanner.next();
        System.out.print("Enter Model: ");
        String model2 = scanner.next();
        System.out.print("Enter carrier: ");
        String carrier2 = scanner.next();
        System.out.print("Enter phone number: ");
        String phoneNumber2 = scanner.next();
        System.out.print("Enter Owner: ");
        String owner2 = scanner.next();
        //Call method
        displayPhone(serialNumber,model,carrier,phoneNumber,owner);
        displayPhone(serialNumber2,model2,carrier2,phoneNumber2,owner2);
        //Call dial method
        System.out.print("\nPhone Calls: ");
        System.out.print("\nPhone Calls: ");
        dial(owner,phoneNumber2);
        dial(owner2,phoneNumber);
        scanner.close();
    }
    //Method to display phone information
    public static void displayPhone(String serialNumber,String model,
                                    String carrier,String phoneNumber,String owner){
        System.out.print("\nCell Phone Details: ");
        System.out.println("Serial Number:" + serialNumber);
        System.out.println("Model:" + model);
        System.out.println("Carrier:" + carrier);
        System.out.println("Phone Number:" + phoneNumber);
        System.out.println("Owner:" + owner);
    }
    //Method to dial a phone number
    public static void dial(String owner,String phoneNumber){
        System.out.print(owner +" " + "is calling"+" "+ phoneNumber);
    }
}
