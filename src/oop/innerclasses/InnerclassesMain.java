package oop.innerclasses;

public class InnerclassesMain {

    public static void main(String[] args) {

        CellPhone phone = new CellPhone("Nokia", "1100");

        phone.turnOn();
        Display display = phone.getDisplay();


    }
}
