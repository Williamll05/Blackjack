import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    void testFaceCardValues() {
        Card jack = new Card(11, "Spades");
        Card queen = new Card(12, "Hearts");
        Card king = new Card(13, "Clubs");

        assertEquals(10, jack.getValue());
        assertEquals(10, queen.getValue());
        assertEquals(10, king.getValue());
    }

    @Test
    void testNumberCardValues() {
        Card seven = new Card(7, "Diamonds");
        assertEquals(7, seven.getValue());
    }

    @Test
    void testToString() {
        Card king = new Card(13, "Spades");
        assertEquals("King of Spades", king.toString());
    }

}
