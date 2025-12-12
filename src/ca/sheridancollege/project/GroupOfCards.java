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

public class GroupOfCards {

    // maximum number of cards for this group
    protected int maxSize;

    // the actual cards currently in the group
    protected ArrayList<Card> cards;

    // constructor – caller decides how many cards this group can hold
    public GroupOfCards(int givenSize) {
        this.maxSize = givenSize;
        this.cards = new ArrayList<Card>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    // deal the "top" card (last one in the list)
    public Card dealCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public int getSize() {
        return cards.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    // optional helper if you ever need to add a card manually
    public void addCard(Card c) {
        if (cards.size() < maxSize) {
            cards.add(c);
        }
    }
}
