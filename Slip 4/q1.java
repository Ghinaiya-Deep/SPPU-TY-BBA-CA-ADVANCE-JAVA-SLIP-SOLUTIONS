import java.sql.*;

public class q1
{
public static void main(String args[])
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:slip3");
String sql="DELETE FROM student WHERE Name LIKE 's%'";
Statement stmt=con.createStatement();
int rows=stmt.executeUpdate(sql);
System.out.println(rows +  " Record Deleted Successfully......");
stmt.close();
con.close();
}
catch(Exception e)
{
System.out.println("Error..."+ e);
}
}
}