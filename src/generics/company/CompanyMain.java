package generics.company;

import generics.company.employee.Accountant;
import generics.company.employee.ITSpecialist;
import generics.company.employee.Manager;

public class CompanyMain {

    public static void main(String[] args) {

        Company company = new Company();

        Department<Accountant> accounting = new Department<>("Accounting", 5);
        Department<ITSpecialist> itDept = new Department<>("IT Department", 10);
        Department<Manager> management = new Department<>("Management", 2);

        Accountant accountant = new Accountant("Alex", 1000.0F);
        ITSpecialist it = new ITSpecialist("James", 2000.0F);
        Manager manager = new Manager("Michal", 4000.0F);

        accounting.addEmployee(accountant);
        itDept.addEmployee(it);
        management.addEmployee(manager);

        company.addDepartment(accounting);
        company.addDepartment(itDept);
        company.addDepartment(management);
        System.out.println(company);
        System.out.println();

        company.giveRise(itDept.getEmployees());
        company.print(company.getDepartments());
        System.out.println();
        company.print(company.getEmployees());

        company.addToITEmployees(itDept.getEmployees());
        company.addToITEmployees(company.getEmployees());







    }


}
