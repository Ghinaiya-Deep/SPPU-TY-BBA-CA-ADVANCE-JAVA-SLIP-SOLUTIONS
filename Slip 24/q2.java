import java.sql.*;
import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:slip24");

            int choice;
            do {
                System.out.println("\n1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Search");
                System.out.println("5. Display");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ENo: ");
                        int eno = sc.nextInt();
                        System.out.print("Enter EName: ");
                        String ename = sc.next();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        System.out.print("Enter Desg: ");
                        String desg = sc.next();

                        PreparedStatement ps1 = con.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?)");
                        ps1.setInt(1, eno);
                        ps1.setString(2, ename);
                        ps1.setDouble(3, salary);
                        ps1.setString(4, desg);
                        ps1.executeUpdate();
                        System.out.println("Record inserted.");
                        break;

                    case 2:
                        System.out.print("Enter ENo to update: ");
                        eno = sc.nextInt();
                        System.out.print("Enter new Salary: ");
                        salary = sc.nextDouble();

                        PreparedStatement ps2 = con.prepareStatement("UPDATE Employee SET salary=? WHERE eno=?");
                        ps2.setDouble(1, salary);
                        ps2.setInt(2, eno);
                        int updated = ps2.executeUpdate();
                        if (updated > 0)
                            System.out.println("Record updated.");
                        else
                            System.out.println("Record not found.");
                        break;

                    case 3:
                        System.out.print("Enter ENo to delete: ");
                        eno = sc.nextInt();

                        PreparedStatement ps3 = con.prepareStatement("DELETE FROM Employee WHERE eno=?");
                        ps3.setInt(1, eno);
                        int deleted = ps3.executeUpdate();
                        if (deleted > 0)
                            System.out.println("Record deleted.");
                        else
                            System.out.println("Record not found.");
                        break;

                    case 4:
                        System.out.print("Enter ENo to search: ");
                        eno = sc.nextInt();

                        PreparedStatement ps4 = con.prepareStatement("SELECT * FROM Employee WHERE eno=?");
                        ps4.setInt(1, eno);
                        ResultSet rs1 = ps4.executeQuery();
                        if (rs1.next()) {
                            System.out.println("ENo: " + rs1.getInt(1));
                            System.out.println("EName: " + rs1.getString(2));
                            System.out.println("Salary: " + rs1.getDouble(3));
                            System.out.println("Desg: " + rs1.getString(4));
                        } else {
                            System.out.println("Record not found.");
                        }
                        break;

                    case 5:
                        Statement st = con.createStatement();
                        ResultSet rs2 = st.executeQuery("SELECT * FROM Employee");
                        System.out.println("ENo\tEName\tSalary\tDesg");
                        while (rs2.next()) {
                            System.out.println(rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" +
                                               rs2.getDouble(3) + "\t" + rs2.getString(4));
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 6);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException se) {
                System.out.println("Closing error: " + se);
            }
        }
    }
}
