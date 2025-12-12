/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Thomas Jacob Agustin
 */
public class User extends Player {

    private double balance;
    private double bet;

    public User(String name, double balance) {
        super(name);
        this.balance = balance;
        this.bet = 0;
    }

    public void placeBet(double amount) {
        if (amount <= 0) {
            System.out.println("Bet must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance! You only have $" + balance);
            return;
        }

        this.bet = amount;
        this.balance -= amount;   // stake goes to the pot
    }


    // Player loses
    public void lose() {
        bet = 0;
    }

    // When player wins, player gets 2x of the betting amount plus its original balance
    public void win() {
        balance += bet * 2;
        bet = 0;
    }

    // A tie will result in getting you bet back
    public void push() {
        balance += bet;
        bet = 0;
    }

    public void resetBet() {
        bet = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double getBet() {
        return bet;
    }

    @Override
    public void play(Deck deck) {
    }
}
