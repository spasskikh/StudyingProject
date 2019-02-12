package concurrency.volatiles;

public class VolatileMain {

    private static volatile int counter = 0;
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) {
        new SimpleWriter().start();
        new SimpleReader().start();
    }

    private static class SimpleWriter extends Thread {
        @Override
        public void run() {
            int localCounter = counter;
            for (int i = 0; i < 10; i++) {
                System.out.println("Writer increments counter " + (++localCounter));
                counter = localCounter;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SimpleReader extends Thread {
        @Override
        public void run() {
            int localCounter = counter;
            while (localCounter < 10) {
                if (localCounter != counter) {
                    System.out.println("Reader read counter " + localCounter);
                    localCounter = counter;
                }
            }
        }
    }
}
