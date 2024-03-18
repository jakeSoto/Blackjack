package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	static final int DECK_SIZE = 52;
    private static final String[] CARD_VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] CARD_SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
    private ArrayList<Card> deck;
    
    
    public Deck() {
    	/* Default constructor uses 1 deck of 52 card */
    	deck = new ArrayList<Card>();
    	initializeDeck();
    }
    
    public Deck(int deckCount) {
    	/* Initialize a new deck with between 1 and 9 (inclusive) decks of cards */
        if (deckCount > 0 && deckCount < 10) {
        	deck = new ArrayList<Card>();
        	
        	for (int count = 0; count < deckCount; count++) {
        		initializeDeck();
        	}
        } else {
        	throw new IllegalArgumentException("You must use between 1 and 9 decks of cards!");
        }
    }
    
    
    private void initializeDeck() {
        /* Initialize the deck with 52 cards in order */
        for (int i = 0; i < CARD_SUITS.length; i++) {
            for (int j = 0; j < CARD_VALUES.length; j++) {
                deck.add(new Card(CARD_VALUES[j], CARD_SUITS[i]));
            }
        }
    }
    
    
    public void shuffleDeck() {
    	/* Deck of cards is shuffled from 5 to 11 times */
    	Random random = new Random();
        int shuffleCount = random.nextInt(5, 11);

        for (int i = 0; i < shuffleCount; i++) {
            for (int j = 0; j < deck.size(); j++) {
                int randomIndex = random.nextInt(deck.size());
                Card currentCard = deck.get(j);
                Card randomCard = deck.get(randomIndex);

                // Swap
                deck.set(j, randomCard);
                deck.set(randomIndex, currentCard);
            }
        }

        System.out.println("Deck shuffled " + shuffleCount + " times.");
    }
    
    
    public Card pop() {
        /* If deck is empty, a new deck is created with 52 cards
           Players keep their current cards in hand		*/
        if (deck.size() < 1) {
            initializeDeck();
            shuffleDeck();
        }
        return deck.remove(0);
    }
    
}
