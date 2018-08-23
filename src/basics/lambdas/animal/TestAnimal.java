package basics.lambdas.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestAnimal {

    public static void main(String[] args) {

        List <Animal> animals = new ArrayList<>();

        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

//        print(animals, new CheckIfHopper());

/*        print(animals, (a) -> true);
        System.out.println();
        print(animals, a -> a.canSwim());
        System.out.println();*/

//        animals.forEach(System.out::println);

//        printGeneric(animals, a -> a.canSwim());

        printPredicat(animals, a -> a.canSwim());


    }

    public static void print (List<Animal> animals, Checker checker) {

        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.println(animal);
            }
        }
    }
    public static void printGeneric(List<Animal> animals, CheckerGeneric<Animal> checkerGeneric) {

        for (Animal animal : animals) {
            if (checkerGeneric.test(animal)) {
                System.out.println(animal);
            }
        }
    }

    public static void printPredicat(List<Animal> animals, Predicate<Animal> predicate) {

        for (Animal animal : animals) {
            if (predicate.test(animal)) {
                System.out.println(animal);
            }
        }
    }




}
