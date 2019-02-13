import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHomeTask {

    public static void main(String[] args) {

        System.out.println(getOddElements(Arrays.asList("John", "Sam", "Alex", "Peter", "Tony")));

        System.out.println("=====");
        System.out.println(toUpperAndDescending(Arrays.asList("John", "Sam", "Alex", "Peter", "Tony")));

        System.out.println("=====");
        System.out.println(getNumbers(Arrays.asList("1, 2, 0", "4, 5")));

        System.out.println("=====");
        getRandomNumbers(10, 25_214_903_917L, 11, 2 ^ 48).limit(10).forEach(System.out::println);

        System.out.println("=====");
        zip(Stream.of(1, 2, 3), Stream.of(1, 2, 3, 4, 5, 6)).forEach(System.out::println);


    }

    private static String getOddElements(List<String> list) {
//        return list.stream()
//                .filter(e -> list.indexOf(e) % 2 != 0)
//                .map(e -> list.indexOf(e) + " " + e)
//                .collect(Collectors.joining(", "));

        return list.stream()
                .mapToInt(list::indexOf)
                .filter(i -> i % 2 != 0)
                .mapToObj(e -> e + " " + list.get(e))
                .collect(Collectors.joining(","));
    }

    private static List<String> toUpperAndDescending(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static List<Integer> getNumbers(List<String> list) {
        return list.stream()
                .flatMap(str ->
                        Arrays.stream(str.split(","))
                                .map(String::trim))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Stream<Long> getRandomNumbers(long seed, long a, long c, long m) {
        return Stream.iterate(seed, elem -> (a * elem + c) % m);
    }

    private static <T> Stream<T> zip(Stream<T> firstStream, Stream<T> secondStream) {
        Iterator<T> first = firstStream.iterator();
        Iterator<T> second = secondStream.iterator();

        Stream<T> zipped = Stream.of(first.next(), second.next());

        while (first.hasNext() && second.hasNext()) {
            Stream<T> temp = Stream.of(first.next(), second.next());
            zipped = Stream.concat(zipped, temp);
        }
        return zipped;
    }


}
