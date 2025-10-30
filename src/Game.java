import java.util.Scanner;

public class Game {

    // This class handles the state of the game - checking inputs to see what the player wants to do and then carrying out those actions for both the player and dealer -
    // checking if players are bust, if they have won, etc
    Deck deck;
    Player player;
    Player dealer;

    boolean gameFinished = false;

    public Game () {
    }
    public void handleChoice(String input) {

        if(input.equals("a") || input.equals("A")) {
            checkGameState(true);
        }

        else if (input.equals("b") || input.equals("B")) {
            player.drawCard(deck);
            System.out.println("You have drawn:");
            player.hand.getLast().printCard();
            printCurrentHands();
            checkGameState(false);
        }

        else if (input.equals("c") || input.equals("C")) {
            player.drawCard(deck);
            System.out.println("You have drawn:");
            player.hand.getLast().printCard();
            printCurrentHands();
            checkGameState(true);
        }
        else System.out.println("Invalid input - please try again.");
    }
    public void newGame() {
        deck = new Deck();
        this.player = new Player();
        this.dealer = new Player();
        player.drawCard(deck);
        player.drawCard(deck);
        dealer.drawCard(deck);
        System.out.println("New game has been initiated!");
        System.out.println("---------------------------------");
        printCurrentHands();
    }

    public void checkGameState(boolean gameOver) {
        int playerHand = player.handValue();

        if (playerHand > 21) { // Player is bust
            System.out.println("You have gone bust! Your hand value totals " + playerHand);
            gameFinished = true;
        }
        else if (playerHand == 21) { // Player is on 21 -- should perhaps add a separate check for if blackjack has been achieved? - Can add when betting is implemented.
            System.out.println("Congratulations, you won!");
            gameFinished = true;
        }
        else if (gameOver) { // Player hand is <21 and the game is over - the dealer will now play and decide fate of the game.
            dealer.drawCard(deck);
            if(dealer.handValue() <= 16) {
                dealer.drawCard(deck);
            }
            int dealerHand = dealer.handValue();
            printCurrentHands();
            if (dealerHand > 21) {
                System.out.println("Dealer has gone bust! Your hand totals " + playerHand + ", and the dealers hand totals " + dealerHand + ".");
            }
            else if (dealerHand > playerHand) {
                System.out.println("The dealer has won! Dealers hand totals " + dealerHand + ", and your hand totals " + playerHand);
            }
            else {
                System.out.println("You have won! Your hand totals " + playerHand + ", and dealers hand totals " + dealerHand);
            }
            gameFinished = true;
        }
    }

    public void printCurrentHands () {
        System.out.println("-----------------------");
        System.out.println("Your current hand:");
        player.printHand();
        System.out.println();
        System.out.println("Dealers current hand:");
        dealer.printHand();
        System.out.println();
    }
}