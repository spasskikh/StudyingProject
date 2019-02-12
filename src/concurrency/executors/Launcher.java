package concurrency.executors;

public class Launcher {

    private static final int POOL_SIZE = 2;

    public static void main(String[] args) {
        System.out.println("Starting MAIN thread");

        GCDRunnable r = new GCDRunnable();

        System.out.println("Leaving MAIN thread");
    }
}
