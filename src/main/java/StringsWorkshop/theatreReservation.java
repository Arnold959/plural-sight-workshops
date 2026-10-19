package StringsWorkshop;

import java.util.Scanner;

public class theatreReservation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Get customer information
        System.out.println("Enter your name:");
        String fullName=scanner.nextLine().trim();
        System.out.print("Date for reservation(MM/dd/yyyy):");
        String date=scanner.nextLine().trim();
        System.out.print("How many tickets would you like:");
        int tickets=scanner.nextInt();
        //call method
        reserverTickets(fullName, date, tickets);
        scanner.close();
    }
    //Method to display reservation
    public static void reserverTickets(String fullName, String date, int tickets){
        // Separate first and last name
        int space=fullName.indexOf(" ");
        String firstName=fullName.substring(0, space);
        String lastName=fullName.substring(space+1);
        //Check number of tickets
        String ticketWord = "tickets";
        if (tickets == 1){
            ticketWord = "tickets";
        }
        //Display confirmation
        System.out.println(tickets + " "+ ticketWord +" "+
                 "reserved for" + " " + date+ " "+"under"+
                " " +lastName +" " + firstName);
    }
}
