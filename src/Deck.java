import java.util.ArrayList;
import java.util.Collections;

class Deck {

    public ArrayList<Card> deck;
    private final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

    public Deck () {
        deck = new ArrayList<>();
        generateNewDeck();
        printDeck();
        shuffle();
        System.out.println();
        printDeck();
    }

    public void generateNewDeck() {
        deck.clear();
        for(int i = 1; i < 14; i++) { // Value 1 represents an Ace - values 11-13 represent jack
            for(String s : suits) {
                deck.add(new Card(i, s));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    } // Instead of shuffling you could just take out a random index from the deck each time a card is drawn, both work though

    public void printDeck() {
        System.out.println("Total cards: " + deck.size());
        for(Card c : deck) {
            c.printCard();
        }
    }
}
