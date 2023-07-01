package ca.sheridancollege.project;

public abstract class Card {
   protected final String suit;
   protected final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    
    public abstract int getValue();
    
    @Override
    public abstract String toString();
}
