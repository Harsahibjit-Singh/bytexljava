import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection con;

    public StudentDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
    }

    public void addStudent(Student s) throws Exception {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES(?, ?, ?, ?)");
        ps.setInt(1, s.getStudentID());
        ps.setString(2, s.getName());
        ps.setString(3, s.getDepartment());
        ps.setDouble(4, s.getMarks());
        ps.executeUpdate();
        System.out.println("Student added!");
    }

    public void viewStudents() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Student");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + 
                               rs.getString(3) + " | " + rs.getDouble(4));
        }
    }

    public void updateMarks(int id, double marks) throws Exception {
        PreparedStatement ps = con.prepareStatement("UPDATE Student SET Marks=? WHERE StudentID=?");
        ps.setDouble(1, marks);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Marks updated!");
    }

    public void deleteStudent(int id) throws Exception {
        PreparedStatement ps = con.prepareStatement("DELETE FROM Student WHERE StudentID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Student deleted!");
    }

    public void close() throws Exception {
        con.close();
    }
}
