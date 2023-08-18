package ca.sheridancollege.project;

public abstract class Card {    //variable for cards
   protected final String suit;
   protected final String rank;

    public Card(String suit, String rank) {   //constructor to initialize cards
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {     //accessors for suit of card
        return suit;
    }

    public String getRank() {   //accessor for rank of card
        return rank;
    }

    
    public abstract int getValue();    //abstract accessor of card
    
    @Override
    public abstract String toString();    //abstract method to print the value of card
}
