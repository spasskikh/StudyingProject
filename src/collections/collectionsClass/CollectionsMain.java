package collections.collectionsClass;

import java.util.*;

public class CollectionsMain {

    public static void main(String[] args) {
//        collections();

        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

//        System.out.println("Original deck of cards");
//        print(deckOfCards);

//        Collections.shuffle(deckOfCards);
//        System.out.println("\nShuffled deck of cards");
//        print(deckOfCards);


//        Collections.sort(deckOfCards, Collections.reverseOrder());
//        Collections.sort(deckOfCards, new CardComparator());
//        System.out.println("\n\nSorted deck of cards");
//        print(deckOfCards);

        Collections.sort(deckOfCards);
        Card card = new Card(Card.Suit.SPADES, Card.Face.QUEEN);
        int position = Collections.binarySearch(deckOfCards, card);
        if (position>0) {
            System.out.println("Card was found at position "+position);
        } else {
            System.out.println("Card was not found");
        }

        System.out.println(Collections.frequency(deckOfCards,card));
        System.out.println("MIN: "+Collections.min(deckOfCards));
        System.out.println("MAX: "+Collections.max(deckOfCards));


    }

    private static void print(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
        }
    }

    private static void collections() {
        List<String> colors = new ArrayList<>();
        colors.add("yellow");
        colors.add("blue");
        colors.add("green");
        colors.add("black");
        colors.add("red");

        System.out.println("Unsorted: " + colors);

        Collections.sort(colors);
        System.out.println("Sorted: " + colors);
    }

}
