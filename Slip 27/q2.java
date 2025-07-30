import java.sql.*;

public class ScrollableResultSetExample {
    public static void main(String[] args) {
        try {
            // Load JDBC-ODBC driver (for older Java versions)
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Connect to database (assume DSN is already created as "mydsn")
            Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");

            // Create scrollable and read-only statement
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher");

            // Move to last row
            rs.last();
            System.out.println("Last Record:");
            System.out.println(rs.getInt("tid") + " " + rs.getString("tname") + " " +
                               rs.getDouble("salary") + " " + rs.getString("subject"));

            // Move to first row
            rs.first();
            System.out.println("\nFirst Record:");
            System.out.println(rs.getInt("tid") + " " + rs.getString("tname") + " " +
                               rs.getDouble("salary") + " " + rs.getString("subject"));

            // Move to next row
            if (rs.next()) {
                System.out.println("\nNext Record:");
                System.out.println(rs.getInt("tid") + " " + rs.getString("tname") + " " +
                                   rs.getDouble("salary") + " " + rs.getString("subject"));
            }

            // Move to previous row
            if (rs.previous()) {
                System.out.println("\nPrevious Record:");
                System.out.println(rs.getInt("tid") + " " + rs.getString("tname") + " " +
                                   rs.getDouble("salary") + " " + rs.getString("subject"));
            }

            // Close everything
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
