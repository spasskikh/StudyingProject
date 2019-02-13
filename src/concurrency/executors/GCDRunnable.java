package concurrency.executors;

import java.util.Random;

/*GREATEST COMMON DIVIDER*/
public class GCDRunnable extends Random implements Runnable {

    private boolean isDaemon;

    GCDRunnable(boolean isDaemon) {
        this.isDaemon = isDaemon;
    }

    @Override
    public void run() {
        String threadType = isDaemon ? "- daemon - " : "- user - ";
        String threadDescription = threadType + Thread.currentThread().getName();
        System.out.println("Starting " + threadDescription);

        for (int i = 0; i < 10_000_000; i++) {
            int a = nextInt();
            int b = nextInt();

            if (i % 10_000 == 0) {
                if (!Thread.interrupted()) {
                    int gcd = computeGCD(a, b);
                    if (gcd > 5) {
                        System.out.println("Running in " + threadDescription + ". GCD of " + a + " and " + b + " is " + gcd);
                    }
                } else {
                    System.out.println("Thread is interrupted!");
                    return;
                }
            }
        }
        System.out.println("Leaving the thread " + threadDescription);
    }

    private int computeGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else {
            return computeGCD(number2, number1 % number2);
        }
    }
}
