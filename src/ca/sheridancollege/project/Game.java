package ca.sheridancollege.project;


// Game.java
import java.util.Scanner;

public class Game {
    private final GroupOfCards deck;
    private final Player player;
    private final Player dealer;

    public Game() {
        deck = new GroupOfCards();
        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    public void start() {
        initializeDeck();
        dealInitialCards();
        playPlayerTurn();
        playDealerTurn();
        determineWinner();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                deck.addCard(card);
            }
        }

        deck.shuffle();
    }

    private void dealInitialCards() {
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        System.out.println(player);
        System.out.println(dealer.getHand().get(0));
    }

    private void playPlayerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (player.getHandValue() < 21) {
            System.out.print("Do you want to hit (H) or stand (S)? ");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("H")) {
                player.addCardToHand(deck.drawCard());
                System.out.println(player);
            } else if (choice.equals("S")) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        System.out.println();
    }

    private void playDealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addCardToHand(deck.drawCard());
        }
        System.out.println(dealer);
        System.out.println();
    }

    private void determineWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("----- Results -----");
        System.out.println(player);
        System.out.println(dealer);

        if (playerValue > 21) {
            System.out.println("Player busts. Dealer wins!");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts. Player wins!");
        } else if (playerValue == dealerValue) {
            System.out.println("It's a tie!");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
