package collections.stackqueue;

import collections.collectionsClass.Card;
import collections.collectionsClass.CardComparator;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {

    public static void main(String[] args) {

//        Queue<Card> cardDeck = new PriorityQueue<>();
        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());

        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        for (int i = 0; i<10; i++) {
            System.out.println(cardDeck.poll());
        }

        System.out.println("Deck size is "+cardDeck.size());

        System.out.println(cardDeck.peek());
        System.out.println(cardDeck.peek());

        System.out.println(cardDeck);

        Iterator<Card> iterator = cardDeck.iterator();
        /*returns unordered elements*/
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+", ");
        }
        System.out.println();

        cardDeck.clear();
        System.out.println("Deck size is "+cardDeck.size());



    }
}
