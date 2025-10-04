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
        for(int i = 1; i < 14; i++) {
            for(String s : suits) {
                deck.add(new Card(i, s));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void printDeck() {
        System.out.println("Total cards: " + deck.size());
        for(Card c : deck) {
            c.printCard();
        }
    }
}
