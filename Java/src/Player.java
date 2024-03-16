import java.util.ArrayList;

public class Player {
    protected ArrayList<Card> hand;
    private int handTotal;
    private int aceCount;
    private boolean busted;

    public Player() {
        this.hand = new ArrayList<Card>();
        this.handTotal = 0;
        this.aceCount = 0;
    }

    public boolean hasBlackjack() {
        if (handTotal == 21) {
            return true;
        }
        return false;
    }

    public boolean addCard(Card card) {
        /* returns true if card is successfully added
         * returns false if card being added busts the player's hand
         */
        int cardValue = card.getValue();

        if (card.isAce()) {
            if (aceCount > 0) {
            }
            else {
                if ((handTotal + cardValue) <= 21) {
                    hand.add(card);
                    aceCount++;
                    handTotal += cardValue;
                }
                else if ((handTotal + 1) <= 21) {
                    hand.add(card);
                    aceCount++;
                    handTotal++;
                }
            }
        }
        else {
            if ((handTotal + cardValue) <= 21) {
                hand.add(card);
                handTotal += cardValue;
            }
            else {
                busted = true;
                System.out.println("Busted!");
                return false;
            }
        }
        return true;
    }

    public int getHandTotal() {
        return handTotal;
    }

    public int getAceCount() {
        return aceCount;
    }

    public boolean bust() {
        return busted;
    }

    

}
