import java.util.ArrayList;

public class Player {

    public boolean hasAce;
    boolean hasBlackjack;
    boolean isBust;
    public ArrayList<Card> hand;

    public Player() {
        hasAce = false;
        hasBlackjack = false;
        isBust = false;
        hand = new ArrayList<>();
    }

    public int handValue() {
        int total = 0;
        for(Card card : hand) {
            total += card.getValue();
            hasAce = (card.getValue() == 1);
        }
        if (hasAce && total <= 21) {
            return total + 10;
        }
        return total;
    }

    public void drawCard(Deck deck) {
        hand.add(deck.deck.getFirst());
        deck.deck.removeFirst();
    }

    public void printHand () {
        for (Card card : hand) {
            card.printCard();
        }
        System.out.println("Total value: " + handValue());
    }
}
