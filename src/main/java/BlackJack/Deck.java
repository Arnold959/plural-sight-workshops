package BlackJack;


import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // List to store all cards
    ArrayList<Card> cards = new ArrayList<>();

    // Constructor creates the deck
    public Deck() {

        String[] suits = {
                "Hearts", "Diamonds", "Clubs", "Spades"
        };

        String[] ranks = {
                "Ace", "2", "3", "4", "5", "6",
                "7", "8", "9", "10",
                "Jack", "Queen", "King"
        };

        // Loop through all suits
        for (String suit : suits) {

            // Loop through all ranks
            for (int i = 0; i < ranks.length; i++) {

                int value = i + 1;

                // Ace is worth 11
                if (i == 0) {
                    value = 11;
                }

                // Jack, Queen and King are worth 10
                if (i >= 10) {
                    value = 10;
                }

                // Add the card to the deck
                cards.add(new Card(suit, ranks[i], value));
            }
        }
    }

    // Shuffle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deal one card from the deck
    public Card dealCard() {
        return cards.remove(0);
    }
}

