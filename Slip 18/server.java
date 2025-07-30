import java.net.*;
import java.io.*;

class server
{
public static void main(String args[]) throws Exception
{
ServerSocket ss=new ServerSocket(500);
System.out.println("Wait for Client.....");

Socket s=ss.accept();
System.out.println("Server Accepted Request....");

DataOutputStream dos=new DataOutputStream(s.getOutputStream());
DataInputStream dis=new DataInputStream(s.getInputStream());
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

while(true)
{
System.out.println("Server: ");
System.out.println(dis.readUTF());
System.out.println("Client: ");
System.out.println(br.readLine());
}
}
}