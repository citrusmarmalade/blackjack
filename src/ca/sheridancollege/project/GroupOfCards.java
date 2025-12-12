/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author Thomas Agustin
 * @author Group 4
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super();              // sets up the cards array
        initializeDeck();     // fill with 52 cards
        shuffle();
    }

    // NEW: create 52 BlackjackCard objects
    private void initializeDeck() {
        int index = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                BlackjackCard card = new BlackjackCard(suit.toString(),
                                                     rank.toString(),
                                                     getCardValue(rank));
                cards[index] = card; // 'cards' comes from GroupOfCards
                index++;
            }
        }
        size = 52;
    }

    // NEW: helper to get card value for blackjack
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
            case ACE:   return 11;   // treat as 11, Hand will adjust
            default:    return 0;
        }
    }
}
