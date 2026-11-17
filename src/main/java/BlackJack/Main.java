package BlackJack;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BLACKJACK GAME ===");

        // Ask for player names
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.nextLine();

        System.out.print("Enter Player 2 name: ");
        String name2 = scanner.nextLine();

        // Create players
        Hand player1 = new Hand(name1);
        Hand player2 = new Hand(name2);

        // Create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // Deal two cards to each player
        for (int i = 0; i < 2; i++) {

            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }

        // Display each player's cards
        player1.showHand();
        player2.showHand();

        // Get each player's score
        int score1 = player1.getScore();
        int score2 = player2.getScore();

        System.out.println("\n=== GAME RESULTS ===");

        // Check who won
        if (score1 > 21 && score2 > 21) {

            System.out.println("Both players busted!");
            System.out.println("No winner.");

        } else if (score1 > 21) {

            System.out.println(name2 + " wins!");

        } else if (score2 > 21) {

            System.out.println(name1 + " wins!");

        } else if (score1 > score2) {

            System.out.println(name1 + " wins!");

        } else if (score2 > score1) {

            System.out.println(name2 + " wins!");

        } else {

            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}

