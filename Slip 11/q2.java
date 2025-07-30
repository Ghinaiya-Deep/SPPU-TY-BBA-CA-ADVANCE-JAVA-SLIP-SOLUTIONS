import java.sql.*;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input Dates
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = sc.nextLine();

        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = sc.nextLine();

        try {
            // Step 2: Load JDBC Driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Step 3: Connect to DB
            Connection con = DriverManager.getConnection("jdbc:odbc:slip11");

            // Step 4: Prepare SQL Query
            String query = "SELECT PID, Pname, Qty, Rate, Amount FROM Product WHERE Sales_date BETWEEN ? AND ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, startDate);
            pst.setString(2, endDate);

            // Step 5: Execute and Display
            ResultSet rs = pst.executeQuery();
            System.out.println("\nSales Report from " + startDate + " to " + endDate + ":");
            System.out.println("PID\tPName\tQty\tRate\tAmount");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("PID") + "\t" +
                        rs.getString("PName") + "\t" +
                        rs.getInt("Qty") + "\t" +
                        rs.getDouble("Rate") + "\t" +
                        rs.getDouble("Amount"));
            }

            // Step 6: Close
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
