package ca.sheridancollege.project;

import java.util.Scanner;

public class Game {
    private final GroupOfCards deck;    //declaring all variables using other classes
    private final Player player;
    private final Player dealer;
    
    
    
    public Game() {     //method used create the objects 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        deck = new GroupOfCards();
        player = new Player(name);
        dealer = new Player("Dealer");
    }


    private void initializeDeck() {     //makes a new deck of cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {     //adds cards to deck
            for (String rank : ranks) {
                Card card = new CardDrawn(suit, rank);
                deck.addCard(card);
            }
        }

        deck.shuffle();    //method used to shuffle the deck
    }

    private void dealInitialCards() {         //Distributes cards to dealer and player
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        System.out.println(player);
        System.out.println(dealer.getHand().get(0));
    }

    private void playPlayerTurn() {    //allows player to play their turn
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

    private void playDealerTurn() {    //allows dealer to play their turn
        while (dealer.getHandValue() < 17) {
            dealer.addCardToHand(deck.drawCard());
        }
        System.out.println(dealer);
        System.out.println();
    }

    private void determineWinner() {     //to determine the winner of the game.
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("----- Results -----");
        System.out.println(player);
        System.out.println(dealer);

        if (playerValue > 21) {
            System.out.println("Player lost. Dealer wins!");
        } else if (dealerValue > 21) {
            System.out.println("Dealer lost. " + player + " wins!");
        } else if (playerValue == dealerValue) {
            System.out.println("It's a tie!");
        } else if (playerValue > dealerValue) {
            System.out.println(player + " wins!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
    
     public void play() {    //method to call all the other methods
        initializeDeck();
        dealInitialCards();
        playPlayerTurn();
        playDealerTurn();
        determineWinner();
    }
     
    public static void main(String[] args) {   //main method to start the game
        Game game = new Game();
        game.play();
    }
}
