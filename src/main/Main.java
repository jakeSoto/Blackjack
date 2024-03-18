package main;

import gui.Window;
import blackjack.Card;

import java.awt.Image;
import java.util.concurrent.TimeUnit;

import blackjack.Blackjack;

public class Main {
	public static final int DEALER_IDENTIFIER = 0;
	public static final int PLAYER_IDENTIFIER = 1;
	public static final int PLAYER_COUNT = 1;
	

	public static void main(String[] args) throws InterruptedException {
		boolean playGame = false;
		
		Window gameWindow  = new Window("Blackjack");
		Blackjack gameManager = new Blackjack(PLAYER_COUNT);
		
		
		// Game Loop
		do {
			gameManager.dealStartingHands();
			
			// Display starting hand images and totals to the GUI
			loadStartingHands(gameManager, gameWindow);
			TimeUnit.SECONDS.sleep(3);

			
			
			// Check for players with blackjack
			int[] handTotals = gameManager.getHandTotals();
			
			for (int i = 1; i < handTotals.length; i++) {
				if (handTotals[i] == 21) {
					System.out.println("Player has Blackjack!");
					break;
				}
			}
			
			// Assurance: checking for dealer blackjack 
			if (gameManager.getDealerCard().isAce() || gameManager.getDealerCard().isFaceCard()) {
				
				System.out.println("Checking if dealer has Blackjack.");
				TimeUnit.SECONDS.sleep(2);
				
				if (handTotals[DEALER_IDENTIFIER] == 21) {
					System.out.println("Dealer has Blackjack!");
					break;
				}
				else {
					System.out.println("Dealer does not have Blackjack.");
				}
			}
			
			
			
			/* if player has doubles, ask if they would like to split 
			 * otherwise ask player if they would like to hit or stay */
			

			
		} while (playGame);
		
	}
	
	
	public static void loadStartingHands(Blackjack gameManager, Window gameWindow) {
		gameWindow.loadImage(gameManager.getDealerCard().getCardImage(), DEALER_IDENTIFIER);
		gameWindow.loadImage(gameManager.CARD_BACK_IMAGE, DEALER_IDENTIFIER);
		gameWindow.displayTotal(gameManager.getDealerCard().getValue(), DEALER_IDENTIFIER);
		
		int[] handTotals = gameManager.getHandTotals();
		
		for (int i = 0; i < PLAYER_COUNT; i++) {
			Image[] playerStartingHand = gameManager.getPlayerHandImages(i);
			
			for (int j = 0; j < playerStartingHand.length; j++) {
				gameWindow.loadImage(playerStartingHand[j], PLAYER_IDENTIFIER);
			}
			
			gameWindow.displayTotal(handTotals[i+1], PLAYER_IDENTIFIER);
		}
	}
	
	
	public static void displayPlayerTotals(Blackjack gameManager, Window gameWindow) {
		int[] handTotals = gameManager.getHandTotals();
		
		gameWindow.displayTotal(handTotals[0], DEALER_IDENTIFIER);
		
		for (int i = 1; i < handTotals.length; i++) {
			gameWindow.displayTotal(handTotals[i], PLAYER_IDENTIFIER);
		}
	}

}

