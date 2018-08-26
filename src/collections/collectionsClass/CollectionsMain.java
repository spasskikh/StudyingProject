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

    public static class Card implements Comparable<Card> {

        private enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}

        private enum Face {ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, DEUCE}

        private final Suit suit;
        private final Face face;

        public Card(Suit suit, Face face) {
            this.suit = suit;
            this.face = face;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }

        @Override
        public int compareTo(Card card) {
            Face[] values = Face.values();
            List<Face> faces = Arrays.asList(values);

            if (faces.indexOf(this.face) < faces.indexOf(card.getFace())) {
                return -1;
            } else if (faces.indexOf(this.face) > faces.indexOf(card.getFace())) {
                return 1;
            } else if (faces.indexOf(this.face) == faces.indexOf(card.getFace())) {
                return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit &&
                    face == card.face;
        }

        @Override
        public int hashCode() {

            return Objects.hash(suit, face);
        }

        @Override
        public String toString() {
            return suit + " " + face;
        }
    }

    public static class CardComparator implements Comparator<Card> {

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
}
