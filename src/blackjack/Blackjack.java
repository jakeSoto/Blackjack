package blackjack;

import java.awt.Image;

public class Blackjack {
	private static int DECK_COUNT = 5;
	
	public Image CARD_BACK_IMAGE;
	
	private Player[] players;
	private Dealer dealer;
	
	
	public Blackjack() {
		/* Construct a game between a dealer and single player */
		dealer = new Dealer(DECK_COUNT);
		
		players = new Player[1];
		players[0] = new Player();
		
		dealer.shuffleDeck();
		CARD_BACK_IMAGE = dealer.getCardBackImage();
	}
	
	
	public Blackjack(int playersCount) {
		/* Construct a game between a dealer and 1 to 3 players */
		if (playersCount > 0 && playersCount < 4) {
			dealer = new Dealer(DECK_COUNT);
			this.players = new Player[playersCount];
			
			for (int i = 0; i < playersCount; i++) {
				players[i] = new Player();
			}
		}
		else {
			throw new IllegalArgumentException("Must have between 1 and 3 Players!");
		}

		
		dealer.shuffleDeck();
		CARD_BACK_IMAGE = dealer.getCardBackImage();
	}
	
	
	public void dealStartingHands() {
		Card tempCard = null;
		
		for (int i = 0; i < 2; i++) {
			tempCard = dealer.dealCard();
			dealer.addCard(tempCard);
			
			for (int j = 0; j < this.players.length; j++) {
				tempCard = dealer.dealCard();
				players[j].addCard(tempCard);
			}
		}
	}
	
	
	public Card getDealerCard() {
		return dealer.getDealerCard();
	}

	
	
	public Image[] getPlayerHandImages(int playerIndex) {
		Player currentPlayer = players[playerIndex];
		Image[] handImages = new Image[currentPlayer.hand.size()];
		
		for (int i = 0; i < currentPlayer.hand.size(); i++) {
			handImages[i] = currentPlayer.hand.get(i).getCardImage();
		}
		
		return handImages;
	}
	
	
	public int[] getHandTotals() {
		int[] handTotals = new int[this.players.length + 1];
		handTotals[0] = dealer.getHandTotal();
		
		for (int i = 0; i < this.players.length; i++) {
			handTotals[i+1] = players[i].getHandTotal();
		}
		
		return handTotals;
	}
	
}
