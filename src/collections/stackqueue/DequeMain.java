package collections.stackqueue;

import collections.collectionsClass.Card;
import collections.collectionsClass.CardComparator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class DequeMain {

    public static void main(String[] args) {

        Queue<Card> cardDeck = new PriorityQueue<>();

        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        Deque<Card> cards = new ArrayDeque<>();
        for (int i = 0; i < 12; i++) {
            cards.offerLast(cardDeck.poll());
        }

        Card card = new Card(Card.Suit.CLUBS, Card.Face.ACE);
        cards.removeFirstOccurrence(card);

        int size = cards.size();
        for (int i = 0; i < size; i++) {
            System.out.println(cards.pollLast());
        }



    }
}
