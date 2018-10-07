package collections.implementations.list;

public class ListTest {

    public static void main(String[] args) {

//        LinkedList ls = new LinkedList();

//        ls.add(1);
//        ls.add(2);
//        ls.add(3);
//        ls.add(4);
//        ls.add(5);

//        ls.add(5,10);
//        System.out.println(ls.toString());
//
//        System.out.println(ls.get(5));
//
//        ls.set(5,20);
//        System.out.println(ls.toString());

//        ls.remove(4);
//        System.out.println(ls.toString());

//        System.out.println(ls.sublist(3,4).toString());

//        System.out.println(ls.contains(2));
//
//        System.out.println(ls.indexof(0));

        ArrayList al = new ArrayList();

        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        al.add(3,10);

        System.out.println(al.toString());

        System.out.println(al.get(6));

        al.set(3,20);

        System.out.println(al.toString());

        System.out.println(al.remove(3));
        System.out.println(al.toString());

        System.out.println(al.sublist(0,4).toString());

        System.out.println(al.contains(3));

        System.out.println(al.indexof(3));



    }

}
