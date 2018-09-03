package generics.company;

import generics.company.employee.Employee;
import generics.company.employee.ITSpecialist;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public <T extends Employee> void addDepartment(Department<T> dept) {
        departments.add(dept);
        this.employees.addAll(dept.getEmployees());
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    /*
     * ? - wildcard
     * might be upper bounded, lower bounded, not bounded
     * */

    public void giveRise(List<? extends Employee> employees) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * 0.2F);
        }
    }

    public void print(List<?> list) {
        System.out.println("Size = " + list.size());
        System.out.println(list);
    }

    public void addToITEmployees(List<? super ITSpecialist> list) {
        list.add(new ITSpecialist("Joe", 3500.0F));
    }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                ", employees=" + employees +
                '}';
    }
}
