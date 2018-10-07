package collections.implementations.queue;

public class QueueTest {


//    public static void main(String[] args) {
//        LinkedQueue lq = new LinkedQueue();
//
//        lq.add(1);
//        lq.add(2);
//        lq.add(3);
//        lq.add(4);
//        lq.add(5);
//
//        System.out.println(lq.toString());
//
//        lq.remove();
//        lq.remove();
//        lq.remove();
//
//        System.out.println(Arrays.toString(lq.toArray()));
//
////        lq.clear();
//
////        System.out.println(lq.toString());
//
//        LinkedQueue lq2 = new LinkedQueue();
//
//        lq2.add(1);
//        lq2.add(2);
//        lq2.add(3);
//        lq2.add(4);
//        lq2.add(5);
//
////        lq.addAllFrom(lq2);
//        lq.removeAllTo(lq2);
//
//        System.out.println(lq2.toString());
//
//        lq2.offer(10);
//
//        lq2.clear();
//
//        lq2.peak();
//
//        System.out.println(lq2.toString());
//
//    }

    public static void main(String[] args) {

        ArrayQueue aq = new ArrayQueue();

        aq.add(1);
        aq.add(2);
        aq.add(3);
        aq.add(4);
        aq.add(5);

        System.out.println(aq.toString());

        aq.remove();
        aq.remove();
        aq.remove();

//        aq.clear();

        System.out.println(aq.toString());

        ArrayQueue aq2 = new ArrayQueue();

        aq2.add(1);
        aq2.add(2);
        aq2.add(3);
        aq2.add(4);
        aq2.add(5);

        aq.addAllFrom(aq2);

        System.out.println(aq2.toString());

        aq.removeAllTo(aq2);

        System.out.println(aq2.toString());

    }
}
