package collections.collectionsClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        List<Card.Face> faces = Arrays.asList(Card.Face.values());

        if (faces.indexOf(c1.getFace()) < faces.indexOf(c2.getFace())) {
            return 1;
        } else if (faces.indexOf(c1.getFace()) > faces.indexOf(c2.getFace())) {
            return -1;
        } else if (faces.indexOf(c1.getFace()) == faces.indexOf(c2.getFace())) {
//                return String.valueOf(c1.getSuit()).compareTo(String.valueOf(c2.getSuit()));
            List<Card.Suit> suits = Arrays.asList(Card.Suit.values());
            if (suits.indexOf(c1.getSuit()) < suits.indexOf(c2.getSuit())) {
                return 1;
            } else if (suits.indexOf(c1.getSuit()) > suits.indexOf(c2.getSuit())) {
                return -1;
            }
            return 0;
        }
        return 0;
    }
}
