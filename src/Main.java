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
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if(inGame) {
                System.out.println("A - Stand");
                System.out.println("B - Hit");
                System.out.println("C - Double down");
                input = scanner.next();
                game.handleChoice(input);
                inGame = !game.gameFinished;
            }
            else {
                System.out.println("A - Start new game");
                System.out.println("B - Exit");
                input = scanner.next();
                if (input.equals("a") || input.equals("A")) {
                    inGame = true;
                    game.newGame();
                }
                else if (input.equals("b") || input.equals("B")) {
                    break;
                }
                else {
                    System.out.println("Invalid input - please try again.");
                    System.out.println();
                }
            }
        }
    }
}
