package lambdas;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

@FunctionalInterface
interface ProcessElement<T extends Number> {
    T processElement(T elem);
}

@FunctionalInterface
interface ExecutiveFunction {
    void process();
}

public class LambdaExample {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        processElements(intList, i -> (int) Math.pow(i, 2));
        processElements(doubleList, i -> Math.pow(i, 2));

        TimeUtils.measure(() -> createRandomArray());
        TimeUtils.measure(() -> Arrays.sort(createRandomArray()));

    }

    private static <T extends Number> void processElements(List<T> list, ProcessElement<T> function) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T t = function.processElement(iterator.next());
            iterator.set(t);
        }
        System.out.println(list);
    }

    private static int[] createRandomArray() {
        int[] arr = new int[1_000_000];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (random.nextInt(arr.length) + 1);
        }
        return arr;
    }

    private static class TimeUtils {

        private static void measure(ExecutiveFunction function) {
            long start = System.currentTimeMillis();
            function.process();
            long end = System.currentTimeMillis();

            System.out.println("Time spend: " + (end - start));
        }
    }
}
