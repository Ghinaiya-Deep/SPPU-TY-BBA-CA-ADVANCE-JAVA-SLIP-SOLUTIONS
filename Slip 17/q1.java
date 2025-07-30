import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\nDisplaying vowels with 3-second delay:\n");

        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toLowerCase(input.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("Vowel: " + ch);
                try {
                    Thread.sleep(3000); // 3 seconds delay
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }
        }

        sc.close();
    }
}
