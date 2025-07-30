import java.applet.Applet;
import java.awt.*;

public class q2 extends Applet implements Runnable
{
int waveoffset=0;
Thread t;


public void init()
{
t=new Thread(this);
t.start();
}

public void paint(Graphics g)
{
g.setColor(Color.BLACK);
g.fillRect(100,50,10,200);

int[] xpoints={110+waveoffset,210+waveoffset,110+waveoffset};
int[] ypoints={50,100,150};

g.drawPolygon(xpoints,ypoints,3);
}

public void run()
{
while(true)
{
waveoffset=(waveoffset==1)?0:1;
repaint();

try
{
Thread.sleep(500);
}
catch(InterruptedException e)
{
System.out.println(e);
}
}
}
}
