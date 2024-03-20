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
    
    
    public void addCard(Card card) {
    	if (card.isAce()) {
    	// Card is an ace
    		if ((this.handTotal + card.getValue()) < 22) {
        	// Ace can be safely added with value 11
    			this.hand.add(card);
    			this.handTotal += card.getValue();
    			this.aceCount++;
    			System.out.println("Ace added as 11.");
    		}
    		else if ((this.handTotal + 1) < 22) {
        	// Ace cannot be safely added, attempt to add with value 1
    			card.setAceValue(1);
    			this.hand.add(card);
    			this.handTotal += card.getValue();
    			this.aceCount++;
    			System.out.println("Ace added as 1.");
    		}
    		// Ace cannot be safely added with value 1, check for existing aces
    		else if (this.aceCount > 0) {
    			boolean addedCard = false;
    			
    			for (int i = 0; i < this.hand.size()-1; i++) {
    				Card cardInHand = this.hand.get(i);
    				
    				if (cardInHand.isAce() && cardInHand.getAceValue() == 11) {
    					cardInHand.setAceValue(1);
    					this.handTotal -= 10;
    					System.out.println("Existing ace changed to 1.");
    					

    					if ((this.handTotal + card.getValue()) < 22) {
    						this.hand.add(card);
    						this.handTotal += card.getValue();
    						this.aceCount++;
    						addedCard = true;
    						break;
    					}
    					else if ((this.handTotal + 1) < 22) {
    						card.setAceValue(1);
    		    			this.hand.add(card);
    		    			this.handTotal += card.getValue();
    		    			this.aceCount++;
    		    			addedCard = true;
    		    			break;
    					}
    				}
    			}
    			if (!addedCard) {
    				this.bust = true;
					this.hand.add(card);
					this.handTotal += card.getValue();
    			}
    		}
    		else {
    		// Ace cannot be safely added, ALL existing aces contain value 1
    			this.bust = true;
				this.hand.add(card);
				this.handTotal += card.getValue();
				System.out.println("Busted!");
    		}
    	}
    	else {
    	// Card is not an ace
    		if ((this.handTotal + card.getValue()) < 22) {
    		// Card can be safely added
    			this.hand.add(card);
    			this.handTotal += card.getValue();
    		}
    		else {
    		// Card cannot be safely added
    			if (this.aceCount > 0) {
    			// change aces
    				boolean addedCard = false;
    				for (int i = 0; i < this.hand.size()-1; i++) {
        				Card cardInHand = this.hand.get(i);
        				
        				if (cardInHand.isAce() && cardInHand.getAceValue() == 11) {
        					cardInHand.setAceValue(1);
        					this.handTotal -= 10;
        					System.out.println("Changed an ace value to 1.");
        					
        					if ((this.handTotal + card.getValue()) < 22) {
        					// if card can now be safely added, add it
        						this.hand.add(card);
        						this.handTotal += card.getValue();
        						addedCard = true;
        						System.out.println("After changing ace, card was added.");
        						break;
        					}
        				}        				
    				}
    				if (!addedCard) {
    				// Card busts the players hand
    					this.bust = true;
    					this.hand.add(card);
						this.handTotal += card.getValue();
						System.out.println("After changing aces, busted!");
    				}
    				
    				
    			}
    			else {
    			// Card busts the players hand
    				this.bust = true;
					this.hand.add(card);
					this.handTotal += card.getValue();
					System.out.println("Busted!");
    			}
    		}
    	}
    	
    }
    
}

