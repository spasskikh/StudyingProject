package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighOrderFunctions {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Alex", "Black", 50000, 25),
                new Person("John", "Green", 75000, 35),
                new Person("Sam", "Brown", 80000, 40),
                new Person("Tony", "Grey", 90000, 50)
        ));

//        testPredicate(persons);
//        testFunction(persons);
        testConsumer(persons);

    }

    private static void testPredicate(List<Person> list) {
        Predicate<Person> isRich = x -> x.getSalary() >= 75000;
        Predicate<Person> isYoung = x -> x.getAge() <= 40;
        System.out.println("Is rich and young...");
        findAll(list, isRich.and(isYoung)).forEach(System.out::println);

        System.out.println("Is rich or young...");
        findAll(list, isRich.or(isYoung)).forEach(System.out::println);

        System.out.println("Is not young...");
        findAll(list, isYoung.negate()).forEach(System.out::println);
    }

    private static <T> List<T> findAll(List<T> elems, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T elem : elems) {
            if (predicate.test(elem)) {
                filteredList.add(elem);
            }
        }
        return filteredList;
    }

    private static void testFunction(List<Person> list) {
        Function<Person, String> fullName = x -> x.getFirstName() + " " + x.getLastName();
        Function<String, String> sayHello = x -> "Hello " + x;

        System.out.println("Say hello...");
        List<String> transformedList = transform(list, sayHello.compose(fullName));
        transformedList.forEach(System.out::println);

        Function<String, String> exclaim = x -> x + "!!!";
        Function<String, String> toUpperCase = String::toUpperCase;
        transform(transformedList, compose(exclaim, toUpperCase)).forEach(System.out::println);

    }

    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        Function<T, T> function = Function.identity();
        for (Function<T, T> f : functions) {
            function = function.andThen(f);
        }
        return function;
    }

    private static <T, R> List<R> transform(List<T> elems, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T elem : elems) {
            result.add(function.apply(elem));
        }
        return result;
    }

    private static void testConsumer(List<Person> persons) {
        Consumer<Person> rise = x -> x.setSalary(x.getSalary() / 10 * 11);
        processList(persons, rise.andThen(System.out::println));
    }

    private static <T> void processList(List<T> elems, Consumer<T> consumer) {
        for (T e : elems) {
            consumer.accept(e);
        }
    }

    private static class Person {
        private String firstName;
        private String lastName;
        private Integer salary;
        private Integer age;

        public Person(String firstName, String lastName, Integer salary, Integer age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return firstName + ' ' + lastName + " salary=" + salary + " age=" + age;
        }
    }

}
