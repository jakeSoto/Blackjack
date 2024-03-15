
public class Blackjack {
    static int DECK_COUNT = 5;
    private Player player;
    private Dealer dealer;

    public Blackjack() {
        player = new Player();
        dealer = new Dealer(DECK_COUNT);
        dealer.shuffleDeck();
    }

    public void dealHands() {
        Card tempCard = null;
        
        for (int i = 0; i < 4; i++) {   // Dealer and player get 2 cards each
            tempCard = dealer.dealCard();
            
            if (i % 2 == 0) {           // Player gets delt cards first
                player.addCard(tempCard);
            } else {
                dealer.addCard(tempCard);
            }
        }
    }

    public void hit(Player player) {

    }

    public void printCard(Card card, boolean player) {
        if (player) {

        }
    }

}
