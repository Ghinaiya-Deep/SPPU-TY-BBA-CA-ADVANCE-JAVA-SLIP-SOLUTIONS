public class q1 {
    public static void main(String[] args) {
        // Get current thread (main thread)
        Thread currentThread = Thread.currentThread();

        // Display name and priority
        System.out.println("Thread Name: " + currentThread.getName());
        System.out.println("Thread Priority: " + currentThread.getPriority());
    }
}
