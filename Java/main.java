import java.util.concurrent.TimeUnit;

public class main {
    static final String DEALER_TEXT = "Dealer Showing: ";
    static final String PLAYER_TEXT = "Player Showing: ";

    public static void main(String[] args) throws InterruptedException {
        boolean playGame = true;
        Window gameWindow = new Window("Blackjack");
        Blackjack gameManager = new Blackjack();
        Player player = gameManager.player;
        Dealer dealer = gameManager.dealer;
        
        while (playGame) {
            playGame = false;
            gameManager.dealHands();
            Card dealerCard = dealer.getStartingHand();

            //gameWindow.setDealerText(DEALER_TEXT + dealer.getStartingHand().getValue());
            gameWindow.displayCard(dealerCard.getCardImage(), true);
            gameWindow.displayCard(dealer.getBlankCard(), true);



            //gameWindow.setPlayerText(PLAYER_TEXT + player.getHandTotal());
            TimeUnit.SECONDS.sleep(2);

            // if (player.hasBlackjack()) {
            //     gameWindow.setPlayerText("Player has Blackjack!");
            //     break;
            // }
            // else if (dealerCard.getValue() >= 10) {
            //     gameWindow.setDealerText("Dealer checking for Blackjack.");
            //     TimeUnit.SECONDS.sleep(2);

            //     if (dealer.hasBlackjack()) {
            //         gameWindow.setDealerText("Dealer has Blackjack, house wins!");
            //         break;
            //     }
            //     else {
            //         gameWindow.setDealerText(DEALER_TEXT + dealer.getStartingHand());
            //     }
            //}
        
        
        
        
        }
    }
}
