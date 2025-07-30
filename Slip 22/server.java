import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started... Waiting for client...");

            Socket s = ss.accept();  // wait for client
            System.out.println("Client connected.");

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            // Send current date and time
            Date date = new Date();
            out.println("Current Server Date & Time: " + date.toString());

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
