import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {
    static final int CARD_WIDTH = 110;
    static final int CARD_HEIGHT = 154;

    private String value;
    private String suit;
    private Image cardImage;


    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
        setImage();
    }

    private void setImage() {
        char suitInitial = suit.charAt(0);
        String imageName = "./images/" + value + "-" + suitInitial + ".png";

        cardImage = new ImageIcon(getClass().getResource(imageName)).getImage();
    }

    public boolean isAce() {
        if (this.value == "A") {
            return true;
        }
        return false;
    }

    public boolean isFaceCard() {
        if (this.value == "J" || this.value == "Q" || this.value == "K") {
            return true;
        }
        return false; 
    }

    public int getValue() {
        if (isAce()) {
            return 11;
        }
        else if (isFaceCard()) {
            return 10;
        }
        else {
            return Integer.parseInt(this.value);
        }
    }

    public Image getCardImage() {
        return this.cardImage;
    }
    
}
