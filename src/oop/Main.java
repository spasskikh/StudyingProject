package oop;

public class Main {

    public static void main(String[] args) {

        System.out.println("Dogs Count = " + Dog.getDogsCount());

        Dog lab = new Dog();
        lab.setName("Charley");
        lab.setBreed("Lab");
        lab.setSize(Size.AVERAGE);

        System.out.println(lab);
        lab.bark();


        Dog sheppard = new Dog("Mike", "Sheppard");
        sheppard.bark();


        Dog doberman = new Dog("Jack", "Doberman");
        doberman.setSize(Size.BIG);
        doberman.bite();

        Size small = Size.SMALL;
        small.toString();

        Size[] enums = Size.values();
        for (Size s : enums) {
            System.out.println(s);
        }


    }
}
