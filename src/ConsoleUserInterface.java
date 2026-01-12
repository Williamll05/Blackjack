import java.util.List;

public class ConsoleUserInterface implements UserInterface {

    /*

    Having this interface in a separate class decouples the rest of the program from System.in,
    allowing for the game interface to change in the future such as implementing a custom GUI.

     */

    public void output (String output) { // Output any string to system.out - used for formatting and other information
        System.out.println(output);
    }

    public void showHand (Player player) {
        List<Card> hand = player.getHand().getHandAsList();
        for (Card card : hand) {
            System.out.println(card.toString());
        }
        System.out.println("Total value: " + player.getHandValue());
    }

    public void showMatchUp (Player player, Player dealer) {
        System.out.println("-----------------------");
        System.out.println("Your current hand:");
        showHand(player);
        System.out.println();
        System.out.println("Dealers current hand:");
        showHand(dealer);
        System.out.println();
    }

}
