package collections.implementations.queue;

public class LinkedQueue extends QueueAbstr {

    @Override
    public boolean add(Integer elem) {

         if (size==0) {
             Node node = new Node (elem);
             head = node;
             tail = node;
             head.prev=tail;
             size++;
         }
         else {
             Node node = new Node(elem);
             tail.prev = node;
             tail = node;
             size++;
         }
        return true;
    }

    @Override
    public Integer remove() {
         if (isEmpty()) {
             System.out.println("No elements.");
         }
         int i = head.elem;
         head = head.prev;
         size--;
        return i;
    }

    @Override
    public Integer element() {
        if (isEmpty()) {
            System.out.println("No elements.");
            return null;
        }
        else return head.elem;
    }

    @Override
    public void clear() {
         size = 0;
         head=null;
    }

    @Override
    public void addAllFrom(Queue q) {
         while (!q.isEmpty()) {
             Node node = new Node (q.remove());
             tail.prev = node;
             tail = node;
             size++;
         }
    }

    @Override
    public void removeAllTo(Queue q) {
        q.addAllFrom(this);
    }

    public boolean offer(Integer elem) {

         class myException extends Exception {
             void noSpace () {
                 System.out.println("Cannot be added.");
             }
         }

         try {
             if (size>5) throw new myException ();
             add(elem);
             return true;
         } catch (myException ex) {
             ex.noSpace();
             return false;
         }
    }

    public Integer poll() {

        class myException extends Exception {
            void noElement () {
                System.out.println("No elements.");
            }
        }

        try {
            if (size==0) throw new myException ();
            return remove();
        } catch (myException ex) {
            ex.noElement();
            return null;
        }
    }

    public Integer peak() {

         class myException extends Exception {
            void noElement () {
                System.out.println("No elements.");
            }
        }

        try {
            if (size==0) throw new myException ();
            return element();
        } catch (myException ex) {
            ex.noElement();
            return null;
        }
    }

    public int[] toArray() {
        int [] arr = new int [size];
        Node tech = head;
        for (int i = 0 ; i<size ; i++) {
            arr [i] = tech.elem;
            tech = tech.prev;
        }
        return arr;
    }

    @Override
    public String toString () {

        StringBuilder sb = new StringBuilder();

        try {
             Node tech = head;
             sb.append("[");
             for (int i = 1 ; i<size ; i++) {
                 sb.append(tech.elem+", ");
                 tech = tech.prev;
             }
             sb.append(tech.elem+"]");

        } catch (NullPointerException e){
            sb.append("]");
        }

        return sb.toString();

    }

}
