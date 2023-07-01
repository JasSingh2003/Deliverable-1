package ca.sheridancollege.project;


public class CardDrawn extends Card {
    
    public CardDrawn(String suit, String rank){
    super(suit, rank);
    }
    @Override
    public  int getValue() {
        if (rank.equals("Ace")) {
            return 11;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }

    @Override
     public String toString() {
        return rank + " of " + suit;
    }
}
