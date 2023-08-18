package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Player {   //declaring name for the player to enter and list of cards.
    protected String name;
    public List<Card> hand;

    public Player(String name) {   //constructor for initializing name and cards
        this.name = name;
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {    //adding card to hand of player or dealer
        hand.add(card);
    }

    public List<Card> getHand() {   //method to return the hand of player or dealer
        return hand;
    }

    public int getHandValue() {    //calculating the value of hand of player and dealer
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }
      @Override   //printing out details of the hand and player.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("'s hand: ");
        for (Card card : hand) {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\nHand value: ").append(getHandValue());
        return   name + "'s " + sb.toString() ;
    }
    
}


    
