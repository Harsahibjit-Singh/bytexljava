import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private String designation;
    private double salary;

    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Designation: %s, Salary: %.2f", id, name, designation, salary);
    }
}

public class PartC {
    private static final String FILENAME = "employees.dat";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Employee newEmployee = new Employee(name, id, designation, salary);
            List<Employee> employees = readAllEmployees();
            employees.add(newEmployee);
            saveAllEmployees(employees);
            System.out.println("Employee added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
        }
    }

    private static void displayEmployees() {
        List<Employee> employees = readAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
        } else {
            System.out.println("\n--- All Employee Records ---");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> readAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                employees = (List<Employee>) ois.readObject();
            } catch (EOFException e) {
                // File is empty, return empty list
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
        }
        return employees;
    }

    private static void saveAllEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}