
public class Card {
    private String value;
    private String suit;
    private String imageName;


    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
        setImageName();
    }

    private void setImageName() {
        char suitInitial = suit.charAt(0);
        imageName = value + "-" + suitInitial + ".png";
    }

    public boolean isAce() {
        if (this.value == "A") {
            return true;
        }
        return false;
    }

    public boolean isFaceCard() {
        if (this.value == "J" || this.value == "Q" || this.value == "K") {
            return true;
        }
        return false; 
    }

    public int getValue() {
        if (isAce()) {
            return 11;
        }
        else if (isFaceCard()) {
            return 10;
        }
        else {
            return Integer.parseInt(this.value);
        }
    }

    public String getImageName() {
        return this.imageName;
    }

    public String toString() {
        if (isAce()) {
            return "Ace of " + this.suit;
        }
        else {
            return (this.value + " of " + this.suit);
        }
    }
}
