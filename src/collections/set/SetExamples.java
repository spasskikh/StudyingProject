package collections.set;

import java.util.*;

public class SetExamples {

    public static void main(String[] args) {

        String[] cars = {"Mini", "Mercedes-Benz", "Audi", "VW", "Smart", "Toyota", "Porsche"};
        String[] otherCars = {"Audi", "Ford", "GMC", "Toyota", "Chevrolet"};

        Set<String> carsHashSet = new HashSet<>(Arrays.asList(cars));
        Set<String> otherCarsHashSet = new HashSet<>(Arrays.asList(otherCars));

        Set<String> carsLinkedHashSet = new LinkedHashSet<>(Arrays.asList(cars));
        Set<String> otherCarsLinkedHashSet = new LinkedHashSet<>(Arrays.asList(otherCars));

        Set<String> carsTreeSet = new TreeSet<>(Arrays.asList(cars));
        Set<String> otherCarsTreeSet = new TreeSet<>(Arrays.asList(otherCars));

        /*unordered unique elements*/
        Set<String> hashSet = new HashSet<>(carsHashSet);
        hashSet.addAll(otherCarsHashSet);
        print(hashSet);

        /*saves initial order, unique elements*/
        Set<String> linkedHashSet = new LinkedHashSet<>(carsLinkedHashSet);
        linkedHashSet.addAll(otherCarsLinkedHashSet);
        print(linkedHashSet);

        /*sorted unique elements*/
        Set<String> treeSet = new TreeSet<>(carsTreeSet);
        treeSet.addAll(otherCarsTreeSet);
        print(treeSet);


    }

    private static void print(Set<String> set) {
        System.out.println(set);
    }

}
