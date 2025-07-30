import java.io.*;
import java.net.*;

public class client {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 7500);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.print("Enter Any Number: ");
        String n = input.readLine();

        out.println(n);
        out.flush();  // Ensure it's sent

        String response = in.readLine();
        System.out.println("Server Response: " + response);

        s.close();
    }
}
