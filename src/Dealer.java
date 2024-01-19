import java.util.Random;

public class Dealer extends Player {
    Random random;
    private Deck cardDeck;

    public Dealer(int deckCount) {
        super();
        this.cardDeck = new Deck(deckCount);
        random = new Random();
    }


    public void shuffleDeck() {
        cardDeck.shuffle();
    }


    public Card dealCard() {
        return cardDeck.pop();
    }

}
