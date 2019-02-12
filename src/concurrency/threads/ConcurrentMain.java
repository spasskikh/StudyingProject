package concurrency.threads;

public class ConcurrentMain {

    public static void main(String[] args) {

        new SimpleThread().start();
        System.out.println("Hello from main");
        new SimpleThread().start();

        new Thread(new SimpleRunner()).start();

        new Thread(()-> System.out.println("Hello from lambda")).start();

    }

}

class SimpleThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("INFO:" + currentThread().getName() + " - " + i);
        }
    }
}

class SimpleRunner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("INFO from Runnable:" + Thread.currentThread().getName() + " - " + i);
        }
    }
}
