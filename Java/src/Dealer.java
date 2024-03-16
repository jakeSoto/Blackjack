import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Dealer extends Player {
    Random random;
    private Deck cardDeck;
    private Image backCardImage;

    public Dealer(int deckCount) {
        super();
        this.cardDeck = new Deck(deckCount);
        random = new Random();

        backCardImage = new ImageIcon(getClass().getResource("./images/BACK.png")).getImage();
    }

    public Card getStartingHand() {
        return hand.get(0);
    }

    public Image getBlankCard() {
        return backCardImage;
    }

    public void shuffleDeck() {
        cardDeck.shuffle();
    }


    public Card dealCard() {
        return cardDeck.pop();
    }

}
