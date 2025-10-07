import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean inGame = false;

        String input;
        int credits = 100;
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        System.out.println("Hello! Welcome to blackjack!");

        while(true) { // Entering our input loop - we will exit out of this once the player exits the game, and the program will finish
            System.out.println("What would you like to do?");
            System.out.println("Type the letter that matches your choice.");
            if(inGame) {
                System.out.println("A - Stand");
                System.out.println("B - Hit");
                System.out.println("C - Double down");
                handleInput();
            }
            else {
                System.out.println("A - Start new game");
                System.out.println("B - Exit");

            }
            String input = scanner.next();
        }
        String input = scanner.next();
        Deck deck = new Deck();
    }

}
