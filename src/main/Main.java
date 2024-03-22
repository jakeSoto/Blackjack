package main;

import gui.Window;
import blackjack.Card;

import java.awt.Image;
import java.util.concurrent.TimeUnit;

import blackjack.Blackjack;

public class Main {
	public static final int DEALER_IDENTIFIER = Blackjack.DEALER_IDENTIFIER;
	public static final int PLAYER_IDENTIFIER = Blackjack.PLAYER_IDENTIFIER;
	public static final int SLEEP_SECONDS = 2;
	

	public static void main(String[] args) {
		boolean play_game = true;
		Window gameWindow = new Window();
		Blackjack gameManager = new Blackjack();
		
		// Game Loop
		while (play_game) {
			gameWindow.initializeWindow();
			gameManager = new Blackjack();
			try {
				play_game = playGame(gameManager, gameWindow);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameWindow.clearPanels();
		}
		
	}
	
	
	public static boolean playGame(Blackjack gameManager, Window gameWindow) throws InterruptedException {
		int playerHandTotal = 0;
		int keyCodeReturn = -1;
		
		gameManager.dealStartingHands();
		
		// Display starting hand images and totals to the GUI
		gameWindow.displayImage(gameManager.getDealerCard().getCardImage(), DEALER_IDENTIFIER);
		gameWindow.displayImage(gameManager.CARD_BACK_IMAGE, DEALER_IDENTIFIER);
		gameWindow.displayTotal(gameManager.getDealerCard().getValue(), DEALER_IDENTIFIER);
		
		Image[] playerStartingHand = gameManager.getPlayerHandImages(PLAYER_IDENTIFIER);
		playerHandTotal = gameManager.getHandTotal(PLAYER_IDENTIFIER);
		
		for (int i = 0; i < playerStartingHand.length; i++) {
			gameWindow.displayImage(playerStartingHand[i], PLAYER_IDENTIFIER);
		}
		gameWindow.displayTotal(playerHandTotal, PLAYER_IDENTIFIER);
		
		
		
		// Check if player has blackjack on starting hand
		if (playerHandTotal == 21) {
			gameWindow.displayActionText("Player has Blackjack!");
			return askNewGame(gameWindow);
		}
		
		// Assurance: checking for dealer blackjack 
		else if (gameManager.getDealerCard().isAce() || gameManager.getDealerCard().isFaceCard()) {
			gameWindow.displayActionText("Checking if dealer has Blackjack.");
			TimeUnit.SECONDS.sleep(SLEEP_SECONDS);
			
			if (gameManager.getHandTotal(DEALER_IDENTIFIER) == 21) {
				playerStartingHand = gameManager.getPlayerHandImages(DEALER_IDENTIFIER);
				playerHandTotal = gameManager.getHandTotal(DEALER_IDENTIFIER);
				gameWindow.flipDealerCard(playerStartingHand, playerHandTotal);
				gameWindow.displayActionText("Dealer has Blackjack!");
				return askNewGame(gameWindow);
			}
			else {
				gameWindow.displayActionText("Dealer does not have Blackjack.");
				TimeUnit.SECONDS.sleep(SLEEP_SECONDS);
			}
		}
		
		
		
		/* USER LOOP */
		boolean stay = false;
		do {
			gameWindow.displayActionText("Press Spacebar to 'Hit' or the S key to 'Stay'");
			keyCodeReturn = gameWindow.getKeyCode();	// get keyboard input code
			
			switch (keyCodeReturn) {
				case 32: 		// HIT
					Card deltCard = gameManager.hitPlayer(PLAYER_IDENTIFIER);
					playerHandTotal = gameManager.getHandTotal(PLAYER_IDENTIFIER);
					gameWindow.displayImage(deltCard.getCardImage(), PLAYER_IDENTIFIER);
					gameWindow.displayTotal(playerHandTotal, PLAYER_IDENTIFIER);
					break;
					
				case 83: 		// STAY
					stay = true;
					gameWindow.displayActionText("Player stayed on: " + gameManager.getHandTotal(PLAYER_IDENTIFIER));
					TimeUnit.SECONDS.sleep(SLEEP_SECONDS);
					break;
			}
		} while (!gameManager.bust(PLAYER_IDENTIFIER) && !stay && gameManager.getHandTotal(PLAYER_IDENTIFIER) != 21);
		
		// Check if player bust
		if (gameManager.bust(PLAYER_IDENTIFIER)) {
			gameWindow.displayActionText("Player Bust, Dealer Wins!");
			return askNewGame(gameWindow);
		}
		else if (gameManager.getHandTotal(PLAYER_IDENTIFIER) == 21) {
			gameWindow.displayActionText("Player Has Blackjack!");
			return askNewGame(gameWindow);
		}
		
		
		/* DEALER LOOP */
		playerStartingHand = gameManager.getPlayerHandImages(DEALER_IDENTIFIER);
		playerHandTotal = gameManager.getHandTotal(DEALER_IDENTIFIER);
		gameWindow.flipDealerCard(playerStartingHand, playerHandTotal);
		TimeUnit.SECONDS.sleep(SLEEP_SECONDS);
		
		while (gameManager.getHandTotal(DEALER_IDENTIFIER) < 17 && !gameManager.bust(DEALER_IDENTIFIER) && gameManager.getHandTotal(PLAYER_IDENTIFIER) != 21) {
			Card deltCard = gameManager.hitPlayer(DEALER_IDENTIFIER);
			gameWindow.displayImage(deltCard.getCardImage(), DEALER_IDENTIFIER);
			gameWindow.displayTotal(gameManager.getHandTotal(DEALER_IDENTIFIER), DEALER_IDENTIFIER);
			TimeUnit.SECONDS.sleep(SLEEP_SECONDS);
		}
		gameWindow.displayTotal(gameManager.getHandTotal(DEALER_IDENTIFIER), DEALER_IDENTIFIER);
		
		
		/* Determine winner */
		if (gameManager.bust(DEALER_IDENTIFIER)) {
			gameWindow.displayActionText("Dealer Bust, Player Wins!");
		}
		else if (gameManager.getHandTotal(DEALER_IDENTIFIER) == 21) {
			gameWindow.displayActionText("Dealer Has Blackjack!");
		}
		else {
			// Dealer closer to 21
			if (gameManager.getHandTotal(DEALER_IDENTIFIER) > gameManager.getHandTotal(PLAYER_IDENTIFIER)) {
				gameWindow.displayActionText("Dealer Wins!");
			}
			// Player closer to 21
			else if (gameManager.getHandTotal(DEALER_IDENTIFIER) < gameManager.getHandTotal(PLAYER_IDENTIFIER)) {
				gameWindow.displayActionText("Player Wins!");
			}
			// Push
			else {
				gameWindow.displayActionText("Push Round!");
			}
		}

		return askNewGame(gameWindow);
	}
	
	
	
	public static boolean askNewGame(Window gameWindow) {
		int keyCodeReturn = gameWindow.getKeyCode();
		boolean playGame = false;
		
		switch (keyCodeReturn) {
			case 32: 		// New game
				playGame = true;
				break;
				
			case 83: 		// Stop playing
				break;
		}
		return playGame;
	}
	

}


