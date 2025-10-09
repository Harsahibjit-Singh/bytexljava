import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               '}';
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 80000));
        employees.add(new Employee("Bob", 25, 65000));
        employees.add(new Employee("Charlie", 35, 95000));
        employees.add(new Employee("David", 25, 72000));

        System.out.println("--- Original List ---");
        employees.forEach(System.out::println);

        System.out.println("\n--- Sorted by Name (Alphabetically) ---");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);

        System.out.println("\n--- Sorted by Age (Ascending) ---");
        employees.sort(Comparator.comparingInt(Employee::getAge));
        employees.forEach(System.out::println);

        System.out.println("\n--- Sorted by Salary (Descending) ---");
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        employees.forEach(System.out::println);
    }
}
