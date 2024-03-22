package blackjack;

import java.util.ArrayList;

public class Player {
    private int handTotal;
    private int aceCount;
    private boolean bust;
    protected ArrayList<Card> hand;
    
    
    public Player() {
    	this.hand = new ArrayList<Card>();
    	this.handTotal = 0;
    	this.aceCount = 0;
    	this.bust = false;
    }
    
    
    public int getHandTotal() {
    	return handTotal;
    }
    
    public boolean bust() {
    	return this.bust;
    }
    
    
    private void add_card(Card card) {
    	if (card.isAce()) {
    		this.aceCount++;
    	}
    	this.hand.add(card);
		this.handTotal += card.getValue();
    }
    
    
    public void addCard(Card card) {
    	if (card.isAce()) {
    	// Card is an ace
    		if ((this.handTotal + card.getValue()) < 22) {
        	// Ace can be safely added with value 11
    			this.add_card(card);
    		}
    		else if ((this.handTotal + 1) < 22) {
        	// Ace cannot be safely added, attempt to add with value 1
    			card.setAceValue(1);
    			this.add_card(card);
    		}
    		// Ace cannot be safely added with value 1, check for existing aces
    		else if (this.aceCount > 0) {
    			boolean addedCard = false;
    			
    			for (int i = 0; i < this.hand.size(); i++) {
    				Card cardInHand = this.hand.get(i);
    				
    				if (cardInHand.isAce() && cardInHand.getAceValue() == 11) {
    					cardInHand.setAceValue(1);
    					this.handTotal -= 10;
    					

    					if ((this.handTotal + card.getValue()) < 22) {
    						this.add_card(card);
    						addedCard = true;
    						break;
    					}
    					else if ((this.handTotal + 1) < 22) {
    						card.setAceValue(1);
    						this.add_card(card);
    		    			addedCard = true;
    		    			break;
    					}
    				}
    			}
    			if (!addedCard) {
    				this.bust = true;
    				this.add_card(card);
    			}
    		}
    		else {
    		// Ace cannot be safely added, ALL existing aces contain value 1
    			this.bust = true;
    			this.add_card(card);
    		}
    	}
    	else {
    	// Card is not an ace
    		if ((this.handTotal + card.getValue()) < 22) {
    		// Card can be safely added
    			this.add_card(card);
    		}
    		else {
    		// Card cannot be safely added
    			if (this.aceCount > 0) {
    			// change aces
    				boolean addedCard = false;
    				for (int i = 0; i < this.hand.size(); i++) {
        				Card cardInHand = this.hand.get(i);
        				
        				if (cardInHand.isAce() && cardInHand.getAceValue() == 11) {
        					cardInHand.setAceValue(1);
        					this.handTotal -= 10;
        					
        					if ((this.handTotal + card.getValue()) < 22) {
        					// if card can now be safely added, add it
        						this.add_card(card);
        						addedCard = true;
        						break;
        					}
        				}        				
    				}
    				if (!addedCard) {
    				// Card busts the players hand
    					this.bust = true;
    					this.add_card(card);
    				}
    				
    				
    			}
    			else {
    			// Card busts the players hand
    				this.bust = true;
    				this.add_card(card);
    			}
    		}
    	}
    	
    }
    
}

