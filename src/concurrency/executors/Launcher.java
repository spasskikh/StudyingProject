package concurrency.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Launcher {

    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        boolean isDaemon = true;

        System.out.println("Starting MAIN thread");
        GCDRunnable runnable = new GCDRunnable(isDaemon);

//        runInOneThread(runnable, isDaemon);

        runWithExecutors(runnable, isDaemon);
        Thread.sleep(1000);
        System.out.println("Leaving MAIN thread");

    }

    private static void runInOneThread(GCDRunnable runnable, boolean isDaemon) throws InterruptedException {
        Thread thread = new Thread(runnable);
        if (isDaemon) {
            thread.setDaemon(true);
        }
        thread.start();
        Thread.sleep(10);
//        thread.interrupt();
    }

    private static void runWithExecutors(GCDRunnable runnable, boolean isDaemon) throws InterruptedException {

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                if (isDaemon) {
                    thread.setDaemon(true);
                }
                return thread;
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE, factory);
        for (int i = 0; i < 5; i++) {
            executor.execute(runnable);
        }
        executor.shutdown();
    }
}
