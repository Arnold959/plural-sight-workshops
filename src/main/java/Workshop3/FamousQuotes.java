package Workshop3;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    //Method to display a quote
    public static void showQuote(String[]quotes,int number){
        System.out.print("\nQuote:"+ quotes[number-1]);
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //Array containing 10 quotes
        String[] quotes ={
                "Believe in yourself.",
                "Never give up.",
                "Dream big and work hard.",
                "Success takes time.",
                "Everyday is a new beginning.",
                "Stay positive.",
                "Practice makes perfect.",
                "Learn from your mistakes.",
                "Hard work pays off.",
                "Keep moving forward."
        };
        String again = "yes";
        //Repeat while the user wants another quote
        while (again.equalsIgnoreCase("yes")){
            System.out.println("\n===FAMOUS QUOTES===");
            System.out.print("Choose a number between 1 and 10: ");
            System.out.println("Enter 0 for a random quote");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            //Display the selected quote
            if(choice >= 1 && choice <= 10){
                showQuote(quotes, choice);
            }else if (choice == 0){
                int randomNumber = random.nextInt(10);
                showQuote(quotes, randomNumber);
            }else {
                System.out.println("Invalid choice.");
            }
            //Ask if the user wants another quote
            System.out.print("\nDo you want another quote? yes/no");
            again = scanner.next();
        }
        System.out.println("Thank you for using Famous Quotes!");
        scanner.close();
    }
}
