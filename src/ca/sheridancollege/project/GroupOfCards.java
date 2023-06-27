package ca.sheridancollege.project;
// GroupOfCards.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards {
    private final List<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
}
