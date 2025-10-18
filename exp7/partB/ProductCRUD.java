import java.sql.*;
import java.util.*;

public class ProductCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false); // for transaction handling

            while (true) {
                System.out.println("\n1. Insert\n2. Display\n3. Update\n4. Delete\n5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO Product VALUES(?, ?, ?, ?)");
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setDouble(3, price);
                    ps.setInt(4, qty);
                    ps.executeUpdate();
                    con.commit();
                    System.out.println("Product added successfully!");

                } else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM Product");
                    System.out.println("ID\tName\tPrice\tQty");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "\t" + rs.getString(2) +
                                           "\t" + rs.getDouble(3) + "\t" + rs.getInt(4));
                    }

                } else if (choice == 3) {
                    System.out.print("Enter Product ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Price: ");
                    double price = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE Product SET Price=? WHERE ProductID=?");
                    ps.setDouble(1, price);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    con.commit();
                    System.out.println("Product updated successfully!");

                } else if (choice == 4) {
                    System.out.print("Enter Product ID to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM Product WHERE ProductID=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    con.commit();
                    System.out.println("Product deleted successfully!");

                } else if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
