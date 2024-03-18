package blackjack;

import java.util.ArrayList;

public class Player {
    private int handTotal;
    private int aceCount;
    protected ArrayList<Card> hand;
    
    
    public Player() {
    	this.hand = new ArrayList<Card>();
    	this.handTotal = 0;
    	this.aceCount = 0;
    }
    
    public int getHandTotal() {
    	return handTotal;
    }
    
    public boolean isPlayer() {
    	return true;
    }
    
    public boolean bust() {
    	if (handTotal > 21) {
    		return true;
    	}
    	return false;
    }
    
    
    public boolean addCard(Card card) {
    	// Card is an ace
    	if (card.isAce()) {
    		// Ace can be safely added with value 11
    		if ((handTotal + card.getValue()) <= 21) {
    			hand.add(card);
    			handTotal += card.getValue();
    			aceCount++;
    			System.out.println("Ace added as 11.");
    		}
    		// Ace cannot be safely added, attempt to add with value 1
    		else if ((handTotal + 1) <= 21) {
    			card.setAceValue(1);
    			hand.add(card);
    			handTotal += card.getValue();
    			aceCount++;
    			System.out.println("Ace added as 1.");
    		}
    		// Ace cannot be safely added with value 1, check for existing aces
    		else if (aceCount > 0) {
    			for (int i = 0; i < hand.size()-1; i++) {
    				Card cardInHand = hand.get(i);
    				
    				if (cardInHand.isAce() && cardInHand.getAceValue() == 11) {
    					// Change ace to 1, update handTotal
    					cardInHand.setAceValue(1);
    					handTotal -= 10;
    					System.out.println("Existing ace changed to 1.");
    					
    					/* if Ace can now be safely added, add it
    					   else look for more aces to change */
    					if ((handTotal + card.getValue()) <= 21) {
    						hand.add(card);
    						handTotal += card.getValue();
    						aceCount++;
    						System.out.println("After changing existing ace, Ace was added as 11.");
    						break;
    					}
    					else if ((handTotal + 1) <= 21) {
    						card.setAceValue(1);
    		    			hand.add(card);
    		    			handTotal += card.getValue();
    		    			aceCount++;
    		    			System.out.println("After changing existing ace, Ace was added as 1.");
    		    			break;
    					}
    				}
    				System.out.println(i);
    			}
    		}
    		// Ace cannot be safely added, ALL existing aces contain value 1
    		else {
    			System.out.println("Busted!");
                return false;
    		}
    	}
    	// Card is not an ace
    	else {
    		// Card can be safely added
    		if ((handTotal + card.getValue()) <= 21) {
    			hand.add(card);
    			handTotal += card.getValue();
    		}
    		// Card cannot be safely added, check for existing aces
    		else if (aceCount > 0) {
    			for (int i = 0; i < hand.size()-1; i++) {
    				Card cardInHand = hand.get(i);
    				
    				if (cardInHand.isAce() && cardInHand.getAceValue() == 11) {
    					// Change ace to 1, update handTotal
    					cardInHand.setAceValue(1);
    					handTotal -= 10;
    					System.out.println("Ace changed to 1.");
    					
    					/* if card can now be safely added, add it
    					   else look for more aces to change */
    					if ((handTotal + card.getValue()) <= 21) {
    						hand.add(card);
    						handTotal += card.getValue();
    						System.out.println("After changing ace, card was added.");
    						break;
    					}
    				}
    				System.out.println(i);
    			}
    		}
    		// Card cannot be safely added, no existing aces
    		else {
    			System.out.println("Busted!");
                return false;
    		}
    	}
    	
    	return true;
    }
    
}

