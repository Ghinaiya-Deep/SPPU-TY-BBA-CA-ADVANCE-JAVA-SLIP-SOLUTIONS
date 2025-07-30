import java.applet.Applet;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class q2 extends Applet implements Runnable {
    int x = 0; // Starting position of the car
    Thread t;
    AtomicBoolean running = new AtomicBoolean(true);

    public void init() {
        setSize(800, 400); // Set applet size
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        // Draw background
        setBackground(Color.cyan);

        // Draw road
        g.setColor(Color.gray);
        g.fillRect(0, 300, 800, 100);

        // Car body
        g.setColor(Color.red);
        g.fillRect(x + 50, 220, 120, 40);
        g.setColor(Color.red);
        g.fillRect(x + 70, 190, 80, 40);

        // Wheels
        g.setColor(Color.black);
        g.fillOval(x + 60, 260, 30, 30);
        g.fillOval(x + 130, 260, 30, 30);
    }

    public void run() {
        while (running.get()) {
            x += 5; // Move car to right
            if (x > getWidth()) {
                x = -200; // Reset position
            }

            repaint(); // Refresh graphics
            try {
                Thread.sleep(50); // Slow down the movement
            } catch (InterruptedException e) {
                running.set(false);
            }
        }
    }

    public void stop() {
        running.set(false);
    }
}
