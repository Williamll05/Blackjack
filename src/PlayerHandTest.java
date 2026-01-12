import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerHandTest {


    @Test
    void testBasicHandValue() {
        PlayerHand hand = new PlayerHand();

        hand.addCard(new Card(10, "Hearts"));
        hand.addCard(new Card(5, "Clubs"));

        assertEquals(15, hand.getHandValue(), "10 + 5 should be 15");
    }

    @Test
    void testBlackjack() {
        PlayerHand hand = new PlayerHand();
        hand.addCard(new Card(1, "Spades"));   // Ace
        hand.addCard(new Card(13, "Hearts"));  // King (Value 10)

        // Should be 11 + 10 = 21
        assertEquals(21, hand.getHandValue(), "Ace + King should be 21");
    }
    @Test
    void testAceBecomesOneWhenBusting() {
        PlayerHand hand = new PlayerHand();
        hand.addCard(new Card(1, "Spades"));  // Ace
        hand.addCard(new Card(9, "Hearts"));  // 9
        hand.addCard(new Card(8, "Clubs"));   // 8

        // Raw total: 1 + 9 + 8 = 18.
        // With ace = 11, total is 28 (bust)
        // Ace value should return to 1
        assertEquals(18, hand.getHandValue(), "Ace + 9 + 8 should be 18");
    }

    @Test
    void testDoubleAces() {
        PlayerHand hand = new PlayerHand();
        hand.addCard(new Card(1, "Spades")); // Ace
        hand.addCard(new Card(1, "Hearts")); // Ace

        // First Ace is 11, Second Ace is 1. Total = 12.
        assertEquals(12, hand.getHandValue(), "Two Aces should equal 12");
    }

}
