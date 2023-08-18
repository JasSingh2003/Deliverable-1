package ca.sheridancollege.project;


public class CardDrawn extends Card {
    
    public CardDrawn(String suit, String rank){   //constructor to initialize the card
    super(suit, rank);
    }
    @Override
    public  int getValue() {    //determining the value of card and also confirming the value of ace.
        if (rank.equals("Ace")) {
            return 11;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }

    @Override    //printing the value of card.
     public String toString() {
        return rank + " of " + suit;
    }
}
