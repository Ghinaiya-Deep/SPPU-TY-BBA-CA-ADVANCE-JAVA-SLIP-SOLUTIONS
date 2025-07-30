import java.io.*;
import java.net.*;

public class server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(7500);
        System.out.println("Server is waiting for Client.....");

        Socket s = ss.accept();
        System.out.println("Client Connected.....");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        int n = Integer.parseInt(in.readLine());
        boolean isprime = checkprime(n);

        String result = n + (isprime ? " is a prime number" : " is not a prime number");
        out.println(result);
        out.flush();  // Important to ensure data is sent

        s.close();
        ss.close();
    }

    public static boolean checkprime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
