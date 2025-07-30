import java.sql.*;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee number to delete: ");
        int eno = sc.nextInt();

        try {
            // Step 1: Load JDBC driver (for MySQL)
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Step 2: Connect to database
            Connection con = DriverManager.getConnection("jdbc:odbc:slip20");

            // Step 3: Prepare and execute delete query
            String query = "DELETE FROM Employee WHERE Eno = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, eno);

            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted successfully.");
            else
                System.out.println("Employee not found.");

            // Step 4: Close connection
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
