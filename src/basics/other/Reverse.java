package basics.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Reverse {

    public static void main(String[] args) {
        reverseWithIterator();
        reverseWithLoop();
    }

    private static void reverseWithIterator() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        ListIterator<Integer> nextIter = list.listIterator();
        ListIterator<Integer> prevIter = list.listIterator(list.size());

        while (nextIter.nextIndex() < prevIter.previousIndex()) {
            Integer next = nextIter.next();
            Integer prev = prevIter.previous();

            nextIter.set(prev);
            prevIter.set(next);
        }

        System.out.println(list);
    }

    private static void reverseWithLoop() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        System.out.println(list);
    }

}
