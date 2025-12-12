/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Thomas Jacob Agustin
 */
public class BlackJackGame extends Game {

    private Deck deck;
    private Dealer dealer;
    private User user;
    private Scanner input;

    public BlackJackGame(String name) {
        super(name);
        deck = new Deck();
        dealer = new Dealer("Dealer");
        user = new User("Player", 100.0); // starting balance
        input = new Scanner(System.in);
    }

    // This is what will be called from main()
    @Override
    public void play() {
        boolean running = true;

        while (running) {
            System.out.println(getName() );
            System.out.println("Balance: $" + user.getBalance());
            System.out.println("1) Play Round");
            System.out.println("2) View Winning Strategy");
            System.out.println("3) Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();

            if (choice == 1) {
                playRound();
            } else if (choice == 2) {
                showWinningStrategy();
            } else if (choice == 3) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    // one round of blackjack
    private void playRound() {
        // 1. Get bet
        System.out.print("Enter the amount you wanna bet ");
        double bet = input.nextDouble();
        user.placeBet(bet);

        // 2. Clear hands from previous round
        user.getHand().clear();
        dealer.getHand().clear();

        // 3. If deck is low on cards, create a new one
        if (deck.getSize() < 15) {
            deck = new Deck();
        }

        // 4. Deal 2 cards to user and dealer
        user.getHand().addCard((BlackjackCard) deck.dealCard());
        user.getHand().addCard((BlackjackCard) deck.dealCard());

        dealer.getHand().addCard((BlackjackCard) deck.dealCard());
        dealer.getHand().addCard((BlackjackCard) deck.dealCard());

        // 5. Player turn: choose Hit or Stand in a loop
        boolean playerDone = false;

        while (!playerDone && !user.getHand().isBust()) {
            System.out.println("\nYour hand value: " + user.getHand().getValue());
            System.out.println("Dealer shows: " + dealer.getHand().getValue());
            System.out.println("1) Hit");
            System.out.println("2) Stand");
            System.out.print("Choose option: ");

            int choice = input.nextInt();

            if (choice == 1) { // Hit
                user.getHand().addCard((BlackjackCard) deck.dealCard());
                System.out.println("You drew a card. New value: " + user.getHand().getValue());
                if (user.getHand().isBust()) {
                    System.out.println("You busted!");
                }
            } else if (choice == 2) { // Stand
                playerDone = true;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        // 6. Dealer plays ONLY if player did not bust
        if (!user.getHand().isBust()) {
            dealer.play(deck);
            System.out.println("\nDealer final value: " + dealer.getHand().getValue());
        }

        // 7. Decide who won
        declareWinner();
        user.resetBet();
    }

    // winning strategy use case
    public void showWinningStrategy() {
        System.out.println("\nBasic Winning Strategy Tips ");
        System.out.println("- Always stand on hard 17 or higher.");
        System.out.println("- Hit on 11 or less.");
        System.out.println("- If dealer shows 6 or less, standing on 12+ is often safer.");
        System.out.println("- Do not take insurance in this basic version.");
    }

    // required by abstract Game class
    @Override
public void declareWinner() {
    int playerValue = user.getHand().getValue();
    int dealerValue = dealer.getHand().getValue();

    if (user.getHand().isBust()) {
        System.out.println("You busted. Dealer wins.");
        user.lose();
    } else if (dealer.getHand().isBust()) {
        System.out.println("Dealer busted. You win!");
        user.win();
    } else if (playerValue > dealerValue) {
        System.out.println("You win!");
        user.win();
    } else if (playerValue < dealerValue) {
        System.out.println("Dealer wins.");
        user.lose();
    } else {
        System.out.println("It's a tie.");
        user.push();
    }

    System.out.println("Your new balance is: $" + user.getBalance());
}
}