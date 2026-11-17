package BlackJack;


public class Card {

    // Variables to store card information
    String suit;
    String rank;
    int value;

    // Constructor to create a card
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    // Return the card name
    public String toString() {
        return rank + " of " + suit;
    }
}
