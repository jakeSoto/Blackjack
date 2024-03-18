package main;

import gui.Window;
import blackjack.Card;

import java.awt.Image;

import blackjack.Blackjack;

public class Main {

	public static void main(String[] args) {
		boolean playGame = false;
		Window gameWindow  = new Window("Blackjack");
		Blackjack gameManager = new Blackjack();
		
		// Game Loop
		do {
			gameManager.dealHands();
			Card dealerCard = gameManager.getDealerCard();
			gameWindow.loadImage(gameManager.getDealerCard().getCardImage(), true);
			
			Image[] playerStartingHand = gameManager.getPlayerHandImages(false);
			for (Image cardImage : playerStartingHand) {
				gameWindow.loadImage(cardImage, false);
			}

			gameWindow.loadImage(gameManager.CARD_BACK_IMAGE, true);

			
		} while (playGame);
		
	}

}

