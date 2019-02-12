package concurrency.executors;

import java.util.Random;

/*GREATEST COMMON DIVIDER*/
public class GCDRunnable extends Random implements Runnable {

    public GCDRunnable() {
    }

    @Override
    public void run() {
        String threadDescription = Thread.currentThread().getName();
        System.out.println("Starting " + threadDescription);

        for (int i = 0; i < 10_000_000; i++) {
            int a = nextInt();
            int b = nextInt();

            if (i % 10_000 == 0) {
                int gcd = computeGCD(a, b);
                if (gcd > 5) {
                    System.out.println("Running in " + threadDescription + ". GCD of " + a + "and " + b + " is " + gcd);
                }
            }
        }
        System.out.println("Leaving the thread " + threadDescription);
    }

    private int computeGCD(int number1, int number2) {
        if (number1 == 0) {
            return number2;
        } else {
            return computeGCD(number2, number1 % number2);
        }
    }
}
