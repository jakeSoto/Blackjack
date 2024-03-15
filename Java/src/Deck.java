import java.util.ArrayList;
import java.util.Random;

public class Deck {
    static final int DECK_SIZE = 52;
    private static final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    Random random;
    private ArrayList<Card> deck;

    public Deck(int deckCount) {
        deck = new ArrayList<Card>();
        random = new Random();

        for (int count = 0; count < deckCount; count++) {
            initializeDeck();
        }
    }

    private void initializeDeck() {
        /* Initialize the deck with 52 cards in order */
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card tempCard = new Card(values[j], suits[i]);
                deck.add(tempCard);
            }
        }
    }

    public void shuffle() {
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
         * Players keep their current cards in hand
         */
        if (deck.size() < 1) {
            initializeDeck();
            shuffle();
        }
        return deck.remove(0);
    }

}
