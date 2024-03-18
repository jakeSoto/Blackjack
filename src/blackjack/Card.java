package blackjack;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {
	public static final int CARD_WIDTH = 110;
    public static final int CARD_HEIGHT = 154;
    
    private String value;
    private Integer aceValue;
    private String suit;
    private Image cardImage;
    
    
    public Card() {
    	this.value = null;
    	this.suit = null;
    	this.aceValue = null;
    }

	public Card(String value, String suit) {
		this.value = value;
        this.suit = suit;
        if (this.isAce()) {
        	this.setAceValue(11);
        }
        setCardImage(this.value, suit.charAt(0));
	}
	
	
	
	public void setAceValue(int aceValue) {
		if (aceValue == 11 || aceValue == 1) {
			this.aceValue = aceValue;
		}
		else {
			throw new IllegalArgumentException("Ace can only be 1 or 11!");
		}
	}
	
	private void setCardImage(String value, char suitInitial) {
        String imageName = "/resources/" + value + "-" + suitInitial + ".png";
        cardImage = new ImageIcon(getClass().getResource(imageName)).getImage();
    }
	
	
	
	public Image getCardImage() {
        return this.cardImage;
    }
	
	public int getAceValue() {
		return aceValue;
	}
	
	public int getValue() {
        if (isAce()) {
            return getAceValue();
        }
        else if (isFaceCard()) {
            return 10;
        }
        else {
            return Integer.parseInt(this.value);
        }
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
	
}

