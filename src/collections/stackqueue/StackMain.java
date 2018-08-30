package collections.stackqueue;

import java.util.Stack;

public class StackMain {

    public static void main(String[] args) {
        passengersProcessing();
    }

    private static void passengersProcessing() {
        Stack<Passenger> bus = new Stack<>();
        Passenger passenger = new Passenger("Petr", "Petr");
        bus.push(new Passenger("Ivan", "Ivan"));
        bus.push(new Passenger("Alex", "Alex"));
        bus.push(new Passenger("John", "John"));
        bus.push(passenger);
        bus.push(new Passenger("Mike", "Mike"));

        System.out.println(passenger + " is on " + bus.search(passenger) + " position");

        System.out.println("Last entered: " + bus.peek());

        while (!bus.isEmpty()) {
            System.out.println(bus.pop());
        }

    }

    private static class Passenger {

        private String name;
        private String surname;

        public Passenger(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }


        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passenger " + name + " " + surname;
        }
    }
}
