import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int handTotal;
    private int aceCount;

    public Player() {
        this.hand = new ArrayList<Card>();
        this.handTotal = 0;
        this.aceCount = 0;
    }

    public boolean bust() {
        if (handTotal > 21) {
            if (aceCount > 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getCardCount() {
        return hand.size();
    }

    public void addCard(Card card) {
        hand.add(card);
        if (card.isAce()) {
            aceCount += 1;
        }

        handTotal += card.getValue();
    }

}
