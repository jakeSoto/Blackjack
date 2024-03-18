package blackjack;

import java.awt.Image;

public class Blackjack {
	static int DECK_COUNT = 5;
	
	public Image CARD_BACK_IMAGE;
	
	protected Player player;
	protected Dealer dealer;
	
	
	public Blackjack() {
		player = new Player();
		dealer = new Dealer(DECK_COUNT);
		dealer.shuffleDeck();
		CARD_BACK_IMAGE = dealer.getCardBackImage();
	}
	
	
	public void dealHands() {
		Card tempCard = null;
		
		for (int i = 0; i < 4; i++) {
			tempCard = dealer.dealCard();
			if (i % 2 == 0) {
				player.addCard(tempCard);
			}
			else {
				dealer.addCard(tempCard);
			}
		}
	}
	
	
	public Card getDealerCard() {
		return dealer.getDealerCard();
	}
	
	
	
	public Image[] getPlayerHandImages(boolean dealer) {
		if (dealer) {
			return getPlayerHandImages(this.dealer);
		}
		else {
			return getPlayerHandImages(this.player);
		}
	}
	
	
	
	public Image[] getPlayerHandImages(Player player) {
		Image[] handImages = new Image[player.hand.size()];
		
		for (int i = 0; i < player.hand.size(); i++) {
			handImages[i] = player.hand.get(i).getCardImage();
		}
		
		return handImages;
	}
	
}
