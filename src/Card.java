public class Card {

    public int value;
    public String suit;
    private final String[] faces = {"Jack", "Queen", "King"};

    public Card (int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public void printCard() {
        if (value <= 10) {
            System.out.println(value + " of " + suit);

        }
        else {
            System.out.println(faces[value - 11] + " of " + suit);
        }
    }

}
