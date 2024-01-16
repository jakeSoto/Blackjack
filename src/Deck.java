import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;  // Standard deck holds 52 cards
    Random random;

    public Deck() {
        deck = new ArrayList<Card>();
        random = new Random();

        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card tempCard = new Card(values[j], suits[i]);
                deck.add(tempCard);
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = random.nextInt(deck.size());
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(randomIndex);

            // Swap
            deck.set(i, randomCard);
            deck.set(randomIndex, currentCard);
        }

    }

    public Card pop() {
        return deck.remove(0);
    }

}
