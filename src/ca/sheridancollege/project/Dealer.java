/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Thomas Jacob Agustin
 */
public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    public void dealToSelf(Deck deck) {
        if (hand == null) {
            hand = new Hand(0);
        }
        hand.addCard((BlackjackCard) deck.dealCard());
    }

    @Override
    public void play(Deck deck) {
        // Ensure hand exists before using it
        if (hand == null) {
            hand = new Hand(0);
        }

        // Dealer hits until value is 17 or more
        while (hand.getValue() < 17) {
            hand.addCard((BlackjackCard) deck.dealCard());
        }
    }
}
