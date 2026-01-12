import java.util.ArrayList;
import java.util.List;

public class Player {

    boolean hasBlackjack;
    boolean isBust;
    private final PlayerHand hand;

    public Player() {
        hasBlackjack = false;
        isBust = false;
        hand = new PlayerHand();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public PlayerHand getHand() {
        return hand;
    }

    public int getHandValue() {
        return hand.getHandValue();
    }
}
