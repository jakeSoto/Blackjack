package blackjack;

import java.awt.Image;

public class Blackjack {	
	public Image CARD_BACK_IMAGE;
	public static final int DEALER_IDENTIFIER = 0;
	public static final int PLAYER_IDENTIFIER = 1;
	
	private static int DECK_COUNT = 5;
	private Player player;
	private Dealer dealer;
	
	
	public Blackjack() {
		/* Construct a game between a dealer and single player */
		dealer = new Dealer(DECK_COUNT);
		dealer.shuffleDeck();
		CARD_BACK_IMAGE = dealer.getCardBackImage();
		
		player = new Player();
	}

	
	
	public void dealStartingHands() {
		// Each player gets 2 cards to start
		for (int i = 0; i < 4; i++) {
			if ((i  % 2) == 0) {
				dealer.addCard(dealer.dealCard());
			}
			else {
				player.addCard(dealer.dealCard());
			}
		}
	}
	
	
	public Card getDealerCard() {
		// Dealer only shows the first card
		return dealer.getDealerCard();
	}

	
	
	public Image[] getPlayerHandImages(int playerIdentifier) {
		Player currentPlayer;
		
		if (playerIdentifier == DEALER_IDENTIFIER) {
			currentPlayer = dealer;
		}
		else {
			currentPlayer = player;
		}
		
		Image[] cardHandImages = new Image[currentPlayer.hand.size()];
		
		for (int i = 0; i < currentPlayer.hand.size(); i++) {
			cardHandImages[i] = currentPlayer.hand.get(i).getCardImage();
		}
		
		return cardHandImages;
	}
	
	
	public int getHandTotal(int playerIdentifier) {
		if (playerIdentifier == DEALER_IDENTIFIER) {
			return dealer.getHandTotal();
		}
		else {
			return player.getHandTotal();
		}
	}
	
	
	public boolean bust(int playerIdentifier) {
		if (playerIdentifier == DEALER_IDENTIFIER) {
			return dealer.bust();
		}
		else {
			return player.bust();
		}
	}
	
	public Card hitPlayer(int playerIdentifier) {
		Card deltCard = dealer.dealCard();
		
		if (playerIdentifier == DEALER_IDENTIFIER) {
			dealer.addCard(deltCard);
		}
		else {
			player.addCard(deltCard);
		}
		
		return deltCard;
	}
	
}


