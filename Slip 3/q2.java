import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class q2 extends Applet implements Runnable {
    int x = 50, y = 50; // Position of the ball
    int dx = 2, dy = 3; // Direction/speed
    int radius = 30;
    Color ballColor = Color.RED;
    Random rand = new Random();

    public void init() {
        setSize(400, 300);
        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        g.setColor(ballColor);
        g.fillOval(x, y, radius, radius);
    }

    public void run() {
        while (true) {
            x += dx;
            y += dy;

            // Bounce off left/right walls
            if (x <= 0 || x >= getWidth() - radius) {
                dx = -dx;
                changeColor();
            }

            // Bounce off top/bottom walls
            if (y <= 0 || y >= getHeight() - radius) {
                dy = -dy;
                changeColor();
            }

            repaint();
            try {
                Thread.sleep(10); // Delay for smooth animation
            } catch (InterruptedException e) {}
        }
    }

    void changeColor() {
        // Generate random color
        ballColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
