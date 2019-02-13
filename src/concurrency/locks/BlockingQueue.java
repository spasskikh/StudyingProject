package concurrency.locks;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        int operators = 5;
        int customers = 21;

        SemaphoreServiceDeck serviceDesk = new SemaphoreServiceDeck(operators, customers);
        ExecutorService executor = Executors.newCachedThreadPool();

        IntStream.range(0, customers)
                .forEach(client -> executor.submit(() -> {
                    serviceDesk.connect();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Number of connected customers " + serviceDesk.getCustomersConnected());
                    System.out.println("Number of customers in queue " + serviceDesk.getCustomersWaiting());
                }));
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    private static class SemaphoreServiceDeck {
        private AtomicInteger connectedCustomers = new AtomicInteger();
        private AtomicInteger customersQueued;

        private Semaphore semaphore;

        public SemaphoreServiceDeck(int operatorsNum, int customersNum) {
            semaphore = new Semaphore(operatorsNum);
            customersQueued = new AtomicInteger(customersNum);
        }

        public void connect() {
            try {
                Random random = new Random();
                semaphore.acquire();
                connectedCustomers.incrementAndGet();
                customersQueued.decrementAndGet();
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }

        private void disconnect() {
            semaphore.release();
            connectedCustomers.decrementAndGet();
        }

        public int getCustomersConnected() {
            return connectedCustomers.get();
        }

        public int getCustomersWaiting() {
            return customersQueued.get();
        }
    }
}
