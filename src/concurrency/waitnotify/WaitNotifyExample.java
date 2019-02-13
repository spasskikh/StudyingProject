package concurrency.waitnotify;

import concurrency.producerconsumer.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class WaitNotifyExample {
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        Message message = new Message();

        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();

    }

    private static class Producer implements Runnable {

        private final Message message;

        Producer(Message message) {
            this.message = message;
        }

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
            for (String str : messages) {
                synchronized (message) {
                    System.out.println("Producing: " + str);
                    message.setMessage(str);
                    message.notify();
                    if (!"DONE".equals(str)) {
                        message.wait();
                    }
                }
                Thread.sleep(400);
            }
        }
    }

    private static class Consumer implements Runnable {

        private final Message message;

        Consumer(Message message) {
            this.message = message;
        }

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
                Thread.sleep(400);
                synchronized (message) {
                    System.out.println("Consuming: " + message.getMessage());
                    if (!"DONE".equals(message.getMessage())) {
                        message.notify();
                        message.wait();
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
