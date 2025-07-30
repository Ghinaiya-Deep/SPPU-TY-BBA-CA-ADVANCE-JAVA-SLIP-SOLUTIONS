public class q1 {
    public static void main(String[] args) {
        int num = 5; // You can change this number
        long factorial = 1;

        System.out.println("Calculating factorial of " + num + "...\n");

        try {
            for (int i = 1; i <= num; i++) {
                factorial *= i;
                Thread.sleep(500); // Delay of 500 milliseconds
            }

            System.out.println("\nFactorial of " + num + " is: " + factorial);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }
    }
}
