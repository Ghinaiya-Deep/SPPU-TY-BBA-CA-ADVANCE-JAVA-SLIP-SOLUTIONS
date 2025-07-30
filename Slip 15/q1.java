public class q1 {
    public static void main(String[] args) {
        System.out.println("Displaying A to Z with 2-second delay:\n");

        try {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.print(ch + " ");
                Thread.sleep(2000); // 2-second delay
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }
}
