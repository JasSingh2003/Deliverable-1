package ca.sheridancollege.project;
// Player.java
import java.util.ArrayList;
import java.util.List;

public class Player {
    public final String name;
    public final List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("'s hand: ");
        for (Card card : hand) {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\nHand value: ").append(getHandValue());
        return sb.toString();
    }
}
