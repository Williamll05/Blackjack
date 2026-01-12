import java.util.ArrayList;
import java.util.List;

public class PlayerHand {

    List<Card> hand;
    boolean hasAce = false;

    public PlayerHand() {
        hand = new ArrayList<>();
    }

    // Could this be seperated further into a value-calculator class? for single responsibility principle in case the way we calculate changes?
    public int getHandValue() { // Get the total value of a players hand, accounting for aces
        int total = 0;
        for(Card card : hand) {
            total += card.getValue();
            if (card.getValue() == 1) {
                hasAce = true;
            }
        }
        if (hasAce && total <= 11) {
            return total + 10;
        }
        return total;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHandAsList() {
        return hand;
    }
}
