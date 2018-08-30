package collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {

        Set<Car> eastCars = new HashSet<>();
        eastCars.add(new Car("VW", "Golf", 45));
        eastCars.add(new Car("VW", "Polo", 35));
        eastCars.add(new Car("Audi", "A3", 60));
        eastCars.add(new Car("BMW", "Z4", 120));
        eastCars.add(new Car("BMW", "440i", 200));


        Set<Car> westCars = new HashSet<>();
        westCars.add(new Car("Toyota", "Auris", 40));
        westCars.add(new Car("Reno", "Cilo", 30));
        westCars.add(new Car("Reno", "Megan", 50));
        westCars.add(new Car("VW", "Golf", 45));
        westCars.add(new Car("VW", "Polo", 35));

        Set<Car> cars = new HashSet<>();
        cars.addAll(eastCars);
        cars.addAll(westCars);
//        print(cars);

        Set<Car> intersect = new HashSet<>(eastCars);
        intersect.retainAll(westCars);
//        print(intersect);

        Set<Car> subtract = new HashSet<>(eastCars);
        subtract.removeAll(westCars);
//        print(subtract);

        Set<Car> exclusive = new HashSet<>(cars);
        exclusive.removeAll(intersect);
        print(exclusive);







    }

    private static void print(Set<Car> cars) {

        System.out.printf("%-20s %-20s %-20s %-20s\n", "Number", "Car brand", "Model", "Price per day");
        int i = 0;
        for (Car car : cars) {
            System.out.printf("%-20s %-20s %-20s %-20s\n", ++i, car.getCarBrend(), car.getModel(), car.getPricePerDay());
        }
    }


}
