import java.util.*;

public class StudentApp {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            StudentDAO dao = new StudentDAO();

            while (true) {
                System.out.println("\n1. Add\n2. View\n3. Update\n4. Delete\n5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Name: "); String name = sc.next();
                    System.out.print("Dept: "); String dept = sc.next();
                    System.out.print("Marks: "); double marks = sc.nextDouble();
                    dao.addStudent(new Student(id, name, dept, marks));

                } else if (ch == 2) {
                    dao.viewStudents();

                } else if (ch == 3) {
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("New Marks: "); double marks = sc.nextDouble();
                    dao.updateMarks(id, marks);

                } else if (ch == 4) {
                    System.out.print("ID: "); int id = sc.nextInt();
                    dao.deleteStudent(id);

                } else if (ch == 5) {
                    System.out.println("Goodbye!");
                    dao.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
