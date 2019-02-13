package concurrency.callableandfuture;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Timer {
    public Instant start;
    public Instant end;

    public double timeInSeconds() {
        return Duration.between(start, end).toMillis() / 1000.0;
    }
}

public class CallableAndFuture {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Future<Double> submit = executorService.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    Timer timer = new Timer();
                    Random random = new Random();

                    timer.start = Instant.now();
                    Thread.sleep(random.nextInt(5000));
                    timer.end = Instant.now();
                    return timer.timeInSeconds();
                }
            });
            list.add(submit);
        }
        executorService.shutdown();

        list.parallelStream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        return 0;
                    }
                })
                .forEach(System.out::println);

    }


}
