import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000); // replace "localhost" with server IP if needed

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String serverDateTime = in.readLine();
            System.out.println("Received from Server: " + serverDateTime);

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
