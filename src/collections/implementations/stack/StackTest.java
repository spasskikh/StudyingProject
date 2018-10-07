package collections.implementations.stack;

public class StackTest {

 /*   public static void main(String[] args) {

        LinkedStack ls = new LinkedStack();

        ls.push (2);
        ls.push (5);
        ls.push (7);
        ls.push (9);
        ls.push (11);
        ls.push (12);
        System.out.println(ls.toString());

        System.out.println("Is empty? - "+ls.empty());

        int a = ls.pop();
        System.out.println(ls.toString());
        int b = ls.pop();
        System.out.println(ls.toString());

        System.out.println("Last element: "+ls.peek()+".");

    }*/

    public static void main(String[] args) {

        ArrayStack as = new ArrayStack ();
        as.push(5);
        as.push(6);
        as.push(7);
        as.push(8);
        as.push(9);
        as.push(10);
        System.out.println(as.toString());

        System.out.println("Is empty? - "+as.empty());

        int a = as.pop();
        System.out.println(as.toString());
        int b = as.pop();
        System.out.println(as.toString());

        System.out.println("Last element: "+as.peek()+".");




    }



}