package BlackJack;


import java.util.ArrayList;

public class Hand {

    // Store the player's name
    String playerName;

    // Store the player's cards
    ArrayList<Card> cards = new ArrayList<>();

    // Constructor
    public Hand(String playerName) {
        this.playerName = playerName;
    }

    // Add a card to the player's hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Calculate the total score
    public int getScore() {

        int total = 0;

        // Add the value of each card
        for (Card card : cards) {
            total += card.value;
        }

        return total;
    }

    // Display the player's cards and score
    public void showHand() {

        System.out.println("\n" + playerName + "'s Hand:");

        // Display each card
        for (Card card : cards) {
            System.out.println(card);
        }

        System.out.println("Total Score: " + getScore());
    }
}

