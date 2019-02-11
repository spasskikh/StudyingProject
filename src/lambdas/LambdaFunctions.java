package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctions {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Square> list = new ArrayList<>(Arrays.asList(
                new Square(1),
                new Square(2),
                new Square(3),
                new Square(4),
                new Square(5)
        ));

//        Predicate
        System.out.println(findMatch(intList, e -> e > 2));
        System.out.println(findMatch(list, e -> e.getSize() > 4));

//        Function
        System.out.println(sum(intList, e -> e * 10));
        System.out.println(sum(list, Square::calcSquare));

//        Bi-function
        System.out.println(combine(intList, 0, e -> e * 10, (e1, e2) -> e1 + e2));
        System.out.println("Sum of all squares: " + combine(list, 0, Square::calcSquare, (e1, e2) -> e1 + e2));
        System.out.println("Max square: " + combine(list, 0, Square::calcSquare, Math::max));

//        Consumer
        list.forEach(e -> e.setSize(e.getSize() * 10));
        list.forEach(System.out::println);

//        Supplier
        Supplier[] shapes = {Square::new, Rectangle::new, Circle::new};
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(shapes.length - 1);
            Supplier supplier = shapes[index];
            supplier.get();
        }
    }

    private static <T> T findMatch(List<T> list, Predicate<T> predicate) {
        for (T elem : list) {
            if (predicate.test(elem)) {
                return elem;
            }
        }
        return null;
    }

    private static <T> Integer sum(List<T> list, Function<T, Integer> function) {
        int sum = 0;
        for (T elem : list) {
            sum += function.apply(elem);
        }
        return sum;
    }

    private static <T, R> R combine(List<T> list, R zeroElem, Function<T, R> function, BinaryOperator<R> combiner) {
        for (T elem : list) {
            zeroElem = combiner.apply(zeroElem, function.apply(elem));
        }
        return zeroElem;
    }

    private static class Square {
        private int size;

        public Square() {
            System.out.println("Square creating");
        }

        public Square(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int calcSquare() {
            return (int) Math.pow(size, 2);
        }

        @Override
        public String toString() {
            return "Square{" +
                    "size=" + size +
                    '}';
        }
    }

    private static class Rectangle {
        public Rectangle() {
            System.out.println("Rectangle creating");
        }
    }

    private static class Circle {
        public Circle() {
            System.out.println("Circle creating");
        }
    }
}

