package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards {
    private final List<Card> cards;  //declaring a list of cards

    public GroupOfCards() {
        cards = new ArrayList<>();    //constructor to initialize the list of cards
    }

    public void addCard(Card card) {   //method to add card to group of cards
        cards.add(card);
    }

    public void shuffle() {   //method to shuffle cards
        Collections.shuffle(cards);
    }

    public Card drawCard() {    //method to draw a card from the group returning null if group is empty.
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
}
