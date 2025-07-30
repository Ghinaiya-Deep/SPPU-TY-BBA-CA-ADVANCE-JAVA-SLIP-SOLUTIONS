import java.net.*;
import java.io.*;

class client
{
public static void main(String args[]) throws Exception
{
Socket s=new Socket("localhost",500);
System.out.println("Client Send Request to Server....");

DataOutputStream dos=new DataOutputStream(s.getOutputStream());
DataInputStream dis=new DataInputStream(s.getInputStream());
InputStreamReader isr=new InputStreamReader(System.in);

BufferedReader br=new BufferedReader(isr);

while(true)
{
System.out.println("Client: ");
dos.writeUTF(br.readLine());
System.out.println("Server: ");
System.out.println(dis.readUTF());
}
}
}