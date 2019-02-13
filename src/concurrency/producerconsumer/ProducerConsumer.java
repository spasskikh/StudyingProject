package concurrency.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();

    }

    private static class Producer implements Runnable {
        private String[] messages = {
                "Threads (Battlefield Band album), 1995",
                "Threads (David S. Ware album), 2003",
                "Threads (Now, Now album), 2012",
                "Threads (Temposhark album), 2010",
                "Threads (song), by This Will Destroy You from their 2008 self-titled album",
                "Thread, a 1999 album by Wideawake",
                "Thread (Red Sun Rising album), 2018",
                "Threads (EP), a 2015 extended play by Sarah Harding",
                "Threads (Sarah Harding song), 2015",
                "DONE"
        };

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            Random random = new Random();
            for (int i = 0; i < messages.length; i++) {
                queue.put(messages[i]);
                System.out.println("Producing: " + messages[i] + ". Size is " + queue.size());
                Thread.sleep(random.nextInt(1000));
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void consume() throws InterruptedException {
            while (true) {
                String message = queue.take();
                System.out.println("Consuming: " + message + ". Size is " + queue.size());
                if (!"DONE".equals(message)) {
                    Thread.sleep(1000);
                } else {
                    return;
                }
            }
        }
    }
}
