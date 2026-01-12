import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean inGame = false;
        String input;
        int credits = 100;
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new ConsoleUserInterface();
        Game game = new Game(ui);
        ui.output("Hello! Welcome to blackjack!");

        while(true) { // Entering input loop - is over when the player exits the game, and the program will finish
            ui.output("What would you like to do?");
            ui.output("Type the letter that matches your choice.");
            ui.output("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if(inGame) {
                ui.output("A - Stand");
                ui.output("B - Hit");
                ui.output("C - Double down");
                input = scanner.next();
                game.handleChoice(input);
                inGame = !game.isGameFinished();
            }
            else {
                ui.output("A - Start new game");
                ui.output("B - Exit");
                input = scanner.next();
                if (input.equals("a") || input.equals("A")) {
                    inGame = true;
                    game.newGame();
                }
                else if (input.equals("b") || input.equals("B")) {
                    break;
                }
                else {
                    ui.output("Invalid input - please try again.");
                    ui.output("");
                }
            }
        }
    }
}
