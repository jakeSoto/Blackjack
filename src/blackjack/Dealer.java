package blackjack;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Dealer extends Player {
	private Deck cardDeck;
	private Image cardBackImage;
	
	
	
	public Dealer() {
		super();
		this.cardDeck = new Deck();
		setCardBackImage();
	}
	
	public Dealer(int deckCount) {
		super();
		this.cardDeck = new Deck(deckCount);
		setCardBackImage();
	}
	
	public boolean isPlayer(Dealer player) {
		if (player == this) {
			return false;
		}
		return true;
	}
	
	
	private void setCardBackImage() {
		cardBackImage = new ImageIcon(getClass().getResource("/resources/BACK.png")).getImage();
	}
	
	public Image getCardBackImage() {
		return cardBackImage;
	}
	
	public Card getDealerCard() {
		return hand.get(0);
	}

	
	public void shuffleDeck() {
		cardDeck.shuffleDeck();
	}
	
	public Card dealCard() {
		return cardDeck.pop();
	}
	
}


