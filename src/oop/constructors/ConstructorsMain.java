package oop.constructors;

import oop.domainmodel.Employee;


public class ConstructorsMain {

    public static void main(String[] args) {

        Employee employee = new Employee();

        Employee ivan = new Employee("Ivan","Developer",1_000);
        System.out.println(ivan);

        Employee petr = new Employee("Petr","Manager",1_500, "Sales");
        System.out.println(petr);

    }
}
