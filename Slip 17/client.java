import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to request: ");
        String fileName = scanner.nextLine();
        out.println(fileName);

        System.out.println("\nResponse from server:");
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        scanner.close();
        socket.close();
    }
}
