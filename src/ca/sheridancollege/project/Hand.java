/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Thomas Jacob Agustin
 */
public class Hand {

    private ArrayList<BlackjackCard> cards;
    private double bet;

    public Hand(double bet) {
        this.bet = bet;
        this.cards = new ArrayList<>();
    }

    public void addCard(BlackjackCard card) {
        cards.add(card);
    }

    public int getValue() {
        int total = 0;
        int aces = 0;

        for (BlackjackCard c : cards) {
            total += c.getValue();
            if (c.getRank().equalsIgnoreCase("ACE")) {
                aces++;
            }
        }

        // Adjust Aces from 11 to 1 if the hand would bust
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public boolean isBust() {
        return getValue() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }

    public double getBet() {
        return bet;
    }

    public ArrayList<BlackjackCard> getCards() {
        return cards;
    }

    public void clear() {
        cards.clear();
        // bet = 0; // This is optional if hand should reset the bet amount
    }
}
