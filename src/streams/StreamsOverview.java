package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOverview {

    private static List<Employee> employeeList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        employeeList.add(new Employee(1, "Alex", "Black", 50000));
        employeeList.add(new Employee(2, "John", "Green", 75000));
        employeeList.add(new Employee(3, "Sam", "Brown", 80000));
        employeeList.add(new Employee(4, "Tony", "Grey", 90000));

//        testStreamFromList();
        testStreamFromFile();


    }

    private static void testStreamFromList() {
        employeeList.stream()
                .filter(e -> e.getSalary() > 75000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Stream.of(ids)
                .map(StreamsOverview::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    private static void testStreamFromFile() throws IOException {
        String[] lines = Files.lines(Paths.get("text.txt"))
                .collect(Collectors.joining())
                .replace(". "," ")
                .replace("."," ")
                .split(" ");

        Stream.of(lines)
                .filter(s -> s.length()<5)
                .map(String::toUpperCase)
                .distinct()
                .sorted((s1,s2) -> s1.length()-s2.length())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static Employee findById(Integer id) {
        if (employeeMap == null) {
            employeeMap = employeeList.stream()
                    .distinct()
                    .collect(Collectors.toMap(Employee::getId, e -> e));
        }
        return employeeMap.get(id);
    }

    private static class Employee {
        private Integer id;
        private String firstName;
        private String lastName;
        private Integer salary;

        public Employee(Integer id, String firstName, String lastName, Integer salary) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
