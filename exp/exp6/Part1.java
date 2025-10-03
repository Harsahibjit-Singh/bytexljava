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
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
    }
}

public class Part1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 80000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 90000));
        employees.add(new Employee("David", 25, 65000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("\nSorted by Name (alphabetically):");
        employees.forEach(System.out::println);
        
        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("\nSorted by Age (ascending):");
        employees.forEach(System.out::println);

        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("\nSorted by Salary (descending):");
        employees.forEach(System.out::println);
    }
}