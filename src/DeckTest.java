import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeckTest {
    @Test
    void testDeckHas52Cards() {
        Deck deck = new Deck();

        // Pull cards until the deck is empty to count them
        int count = 0;
        try {
            while (true) {
                deck.deal();
                count++;
            }
        } catch (IllegalStateException e) {
            // Expected when the deck is empty
        }

        assertEquals(52, count, "A new deck should contain 52 cards");
    }

    @Test
    void testDealReturnsCard() {
        Deck deck = new Deck();
        Card c = deck.deal();
        assertNotNull(c, "Deal should return a Card object");
    }

}
