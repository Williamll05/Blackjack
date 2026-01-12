public class Game {

    // This class handles the state of the game - checking inputs to see what the player wants to do and then carrying out those actions for both the player and dealer -
    // checking if players are bust, if they have won, etc
    private Deck deck;
    private Player player;
    private Player dealer;

    private boolean gameFinished = false;

    private UserInterface ui;

    public Game (UserInterface ui) {
        this.ui = ui;
    }
    public void handleChoice(String input) {

        input = input.trim();

        // Could be replaced by a switch statement probably
        if (input.equals("a") || input.equals("A")) {       // A, B and C are shortened inputs for user experience -
                                                            // A represents Stand, B represents Hit, C represents Double-down

            checkGameState(true);                  // Stand - check current state and finish game
        }

        else if (input.equals("b") || input.equals("B")) { // Hit - draw a card
            Card newCard = deck.deal();
            player.receiveCard(newCard);
            ui.output("You have drawn:");
            ui.output(newCard.toString());
            ui.showMatchUp(player, dealer);
            checkGameState(false);
        }

        else if (input.equals("c") || input.equals("C")) { // Double-down - draw a card then finish game
            Card newCard = deck.deal();
            player.receiveCard(newCard);
            ui.output("You have drawn:");
            ui.output(newCard.toString());
            ui.showMatchUp(player, dealer);
            checkGameState(true);
        }
        else ui.output("Invalid input - please try again.");
    }
    public void newGame() {
        gameFinished = false;

        deck = new Deck();
        this.player = new Player();
        this.dealer = new Player();

        player.receiveCard(deck.deal());

        player.receiveCard(deck.deal());

        dealer.receiveCard(deck.deal());

        ui.output("New game has been initiated!");
        ui.output("---------------------------------");
        ui.showMatchUp(player, dealer);
    }

    public void checkGameState(boolean gameOver) {
        int playerHandVal = player.getHandValue();
        int dealerHandVal;
        if (playerHandVal > 21) { // Player is bust
            ui.output("You have gone bust! Your hand value totals " + playerHandVal + ". :(");
            gameFinished = true;
        }
        else if (playerHandVal == 21) { // todo Add the ability for dealer to draw with the player
            ui.output("Congratulations, you won!");
            gameFinished = true;
        }
        else if (gameOver) { // Player hand is <21 and the game is over - the dealer will now play and decide fate of the game.
            dealer.receiveCard(deck.deal());
            while (dealer.getHandValue() <= 16) {
                dealer.receiveCard(deck.deal());
            }
            dealerHandVal = dealer.getHandValue();
            ui.showMatchUp(player, dealer);
            if (dealerHandVal > 21) {
                ui.output("Dealer has gone bust! Your hand totals " + playerHandVal + ", and the dealers hand totals " + dealerHandVal + ".");
            }
            else if (dealerHandVal > playerHandVal) {
                ui.output("The dealer has won! Dealers hand totals " + dealerHandVal + ", and your hand totals " + playerHandVal);
            }
            else {
                ui.output("You have won! Your hand totals " + playerHandVal + ", and dealers hand totals " + dealerHandVal);
            }
            gameFinished = true;
        }
    }

    public boolean isGameFinished() {
        return gameFinished;
    }
}