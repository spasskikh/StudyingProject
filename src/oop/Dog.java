package oop;

public class Dog {

    private static int dogsCount;

    private int paws = 4;
    private int tail = 1;
    private String name;
    private String breed;
    private String size;

    public Dog() {
        dogsCount++;
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
        dogsCount++;
    }

    public static int getDogsCount() {
        return dogsCount;
    }

    public int getPaws() {
        return paws;
    }

    public void setPaws(int paws) {
        if (paws == 4) {
            this.paws = paws;
        } else {
            System.out.println("User tried to assign " + paws + " paws for a dog.");
            System.out.println("Correct number is 4.");
        }
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        if (tail == 1) {
            this.tail = tail;
        } else {
            System.out.println("User tried to assign " + tail + " tails for a dog.");
            System.out.println("Correct number is 1.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size.equalsIgnoreCase("Big") ||
                size.equalsIgnoreCase("Average") ||
                size.equalsIgnoreCase("Small")) {
            this.size = size;
        } else {
            System.out.println("Size should be one of this: Big, Average, Small.");
        }
    }

    public void bark() {
        if (size.equalsIgnoreCase("Big")) {
            System.out.println("Wof - Wof");
        } else if (size.equalsIgnoreCase("Average")) {
            System.out.println("Raf - Raf");
        } else {
            System.out.println("Tiaf - tiaf");
        }
    }

    public void bite() {
        if (dogsCount > 2) {
            System.out.println("Dogs are biting you!!!");
        } else {
            bark();
        }

    }

    @Override
    public String toString() {
        return "Dog: " +
                "breed = " + breed +
                ", name = " + name +
                ", paws = " + paws +
                ", tail = " + tail +
                ", size = " + size;
    }
}
