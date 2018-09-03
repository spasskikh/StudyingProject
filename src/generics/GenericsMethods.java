package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsMethods {

    public static void main(String[] args) {

        /*
        * E - Element
        * N - Number
        * T - Type
        * V - Value
        * S,U, etc
        * */

        /*at first the most specific method is called*/

        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        String[] stringArray = {"1", "2", "3", "4", "5", "6"};

        printArray(intArray);
        printArray(doubleArray);
        printArray(stringArray);

        printArrayGeneric(intArray);
        printArrayGeneric(doubleArray);
        printArrayGeneric(stringArray);

        System.out.println("Max for array of integers = " + findMax(intArray));
        System.out.println("Max for array of doubles = " + findMax(doubleArray));
//        System.out.println("Max for array of strings = " +findMax(stringArray));

        Number n = Integer.valueOf(20);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        printElements(list);      //compilation error if no wildcard in method params

        List<Integer> integers = Arrays.asList(intArray);
        printElements(integers);        //compilation error if no wildcard in method params

        printElements(Arrays.asList(intArray));

        MyBox<Integer> myBox = new MyBox<>("some string");
        System.out.println(MyBox.returnValue(0.03));


    }

    private static void printArray(Integer[] intArray) {
        System.out.println("Non generic method called");
        for (Integer element : intArray) {
            System.out.printf("%s, ", element);
        }
        System.out.println();
    }

    private static void printArray(Double[] doubleArray) {
        System.out.println("Non generic method called");
        for (Double element : doubleArray) {
            System.out.printf("%s, ", element);
        }
        System.out.println();
    }

    private static void printArray(String[] stringArray) {
        System.out.println("Non generic method called");
        for (String element : stringArray) {
            System.out.printf("%s, ", element);
        }
        System.out.println();
    }

    //    at first T is replaced with Object
    private static <T> void printArrayGeneric(T[] stringArray) {
        System.out.println("Generic method called");
        for (T element : stringArray) {
            System.out.printf("%s, ", element);
        }
        System.out.println();
    }


    //    at first T is replaced with Number
    //    upper bounder, class should be first, interfaces are extended, not implemented,
    private static <T extends Number & Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T e : array) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    private static void printElements(List<? extends Number> list) {
        for (Number n : list) {
            System.out.printf("%s %n", n);
        }
        System.out.println();
    }



}
