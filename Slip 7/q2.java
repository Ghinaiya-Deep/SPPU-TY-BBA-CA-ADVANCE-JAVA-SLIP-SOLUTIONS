class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(100); // sleep for 100 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        NumberThread nt = new NumberThread();
        nt.start();  // start the thread
    }
}
