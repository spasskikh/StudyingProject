package oop;

public class Main {

    public static void main(String[] args) {

        System.out.println("Dogs Count = " + Dog.getDogsCount());

        Dog lab = new Dog();
        lab.setName("Charley");
        lab.setBreed("Lab");
        lab.setPaws(5);
        lab.setTail(2);
        lab.setSize("Average");

        System.out.println(lab);
        lab.bark();


        Dog sheppard = new Dog("Mike", "Sheppard");
        sheppard.setSize("Big");
        sheppard.bark();


        Dog doberman = new Dog("Jack","Doberman");
        doberman.setSize("Big");
        doberman.bite();

    }
}
