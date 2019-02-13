package concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SynchronizedBuffer {

    /*true - fairness parameter*/

    private static final Lock monitor = new ReentrantLock(true);
    private static final Condition canWrite = monitor.newCondition();
    private static final Condition canRead = monitor.newCondition();

    private static int buffer = 0;
    private static boolean isEmpty = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(SynchronizedBuffer::blockingWrite).start();
        new Thread(SynchronizedBuffer::blockingRead).start();
    }

    private static void blockingWrite() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (!isEmpty) {
                    System.out.println("Writer is trying to access a resource");
                    canWrite.await(5, SECONDS);
                }
                buffer++;
                isEmpty = false;
                System.out.println("Writer wrote: " + buffer);
                canRead.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }
        }
    }

    private static void blockingRead() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (isEmpty) {
                    System.out.println("Reader is trying to access a resource");
                    canRead.await(5, SECONDS);
                }
                int readValue = buffer;
                isEmpty = true;
                System.out.println("Reader read: " + readValue);
                canWrite.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }
        }
    }
}
