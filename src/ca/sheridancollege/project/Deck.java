/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Thomas Jacob Agustin
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52);          // this deck has a max size of 52
        initializeDeck();   // fill it with 52 cards
        shuffle();
    }

    // create 52 BlackjackCard objects (4 suits × 13 ranks)
    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                BlackjackCard card = new BlackjackCard(
                        suit.toString(),
                        rank.toString(),
                        getCardValue(rank)
                );
                cards.add(card); // cards from GroupOfCards
            }
        }
    }

    // helper to get card value for blackjack
    private int getCardValue(Rank rank) {
        switch (rank) {
            case TWO:   return 2;
            case THREE: return 3;
            case FOUR:  return 4;
            case FIVE:  return 5;
            case SIX:   return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE:  return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:  return 10;
            case ACE:   return 11;   // Hand will adjust if needed
            default:    return 0;
        }
    }
}
