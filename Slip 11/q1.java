  import java.net.*;

public class q1
{
public static void main(String args[])
{
try
{
InetAddress c=InetAddress.getLocalHost();
System.out.println("IP Adress : "+ c.getHostAddress());
System.out.println("Name : "+c.getHostName());
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}