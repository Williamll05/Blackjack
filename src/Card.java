public class Card {

    private int value;
    private String suit;
    private final String[] faces = {"Jack", "Queen", "King"};

    public Card (int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        String card;
        if (value <= 10) {
            card = (value + " of " + suit);

        }
        else {
            card = (faces[value - 11] + " of " + suit);
        }
        return card;
    }

    public int getValue() {
        return Math.min(value, 10); // Return either the number card value, or if face card, return 10
    }

}
