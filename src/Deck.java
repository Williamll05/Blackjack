import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {

    private final List<Card> deck;
    private final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

    public Deck () {
        deck = new ArrayList<>();
        generateNewDeck();
    }

    public void generateNewDeck() {
        deck.clear();
        for(int i = 1; i < 14; i++) { // Value 1 represents an Ace - values 11-13 represent jack
            for(String s : suits) {
                deck.add(new Card(i, s));
            }
        }
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(deck);
    } // Instead of shuffling you could just take out a random index from the deck each time a card is drawn (and ensure you remove it from the deck), both likely work though

/*      public void printDeck() {
            System.out.println("Total cards: " + deck.size());
            for(Card c : deck) {
            GameInterface.output(c.getCardAsString());
        }
    }
*/
    public Card deal() {
        if(deck.isEmpty()) throw new IllegalStateException("Deck is empty");
        return deck.removeFirst();
    }
}
