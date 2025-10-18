import java.sql.*;

public class FetchEmployee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";  // replace with your DB
        String user = "root";
        String pass = "password";

        try {
            // Step 1: Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Step 3: Create and execute query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            // Step 4: Display results
            System.out.println("EmpID\tName\tSalary");
            while (rs.next()) {
                System.out.println(rs.getInt("EmpID") + "\t" +
                                   rs.getString("Name") + "\t" +
                                   rs.getDouble("Salary"));
            }

            // Step 5: Close connection
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
