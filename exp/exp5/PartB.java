import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id='" + id + "', grade='" + grade + "'}";
    }
}

public class PartB {
    public static void main(String[] args) {
        Student student = new Student("John Doe", "S12345", "A+");
        String filename = "student.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("Student object serialized successfully.");
            System.out.println("Original Object: " + student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student deserializedStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            deserializedStudent = (Student) ois.readObject();
            System.out.println("\nStudent object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (deserializedStudent != null) {
            System.out.println("Deserialized Object: " + deserializedStudent);
        }
    }
}