import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", marks=" + marks +
               '}';
    }
}

public class StudentStreamProcessor {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Eve", 85));
        students.add(new Student("Frank", 72));
        students.add(new Student("Grace", 95));
        students.add(new Student("Heidi", 78));
        students.add(new Student("Ivan", 65));
        students.add(new Student("Judy", 91));

        System.out.println("--- Original Student List ---");
        students.forEach(System.out::println);
        
        System.out.println("\n--- Names of Students with Marks > 75% (Sorted by Marks) ---");
        List<String> topStudentNames = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted(Comparator.comparingInt(Student::getMarks))
            .map(Student::getName)
            .collect(Collectors.toList());
            
        topStudentNames.forEach(System.out::println);
    }
}
