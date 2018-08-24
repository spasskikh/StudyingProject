package oop.domainmodel;

public class Employee {

    private static int id;
    private int empId;
    private String name;
    private String position;
    private int salary;
    private String department;

    static {
        id = 1_000;
        System.out.println("Static initialization block called.");
    }

    {
        department = "IT";
        System.out.println("Non-static initialization block called.");
    }

    public Employee() {
        this("A", "B", 1);
        System.out.println("Empty constructor called.");
    }

    public Employee(String name, String position, int salary) {
        this(name, position, salary, "IT");
        System.out.println("Constructor with 3 params called.");
    }

    public Employee(String name, String position, int salary, String department) {
        this.empId = ++id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
        System.out.println("Constructor with 4 params called.");
    }

    public static int getId() {
        return id;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
