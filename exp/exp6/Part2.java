import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", marks=" + marks + '}';
    }
}

public class Part2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Eve", 85.0));
        students.add(new Student("Frank", 72.5));
        students.add(new Student("Grace", 95.5));
        students.add(new Student("Heidi", 75.0));
        students.add(new Student("Ivan", 89.9));

        List<String> topStudentNames = students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students with marks > 75% (sorted by marks):");
        topStudentNames.forEach(System.out::println);
    }
}