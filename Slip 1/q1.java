import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;

public class q1 extends Applet implements Runnable
{
String msg="Welcome to Java Programming World.......";
Thread t=null;

public void init()
{
setBackground(Color.red);
setForeground(Color.black);
t=new Thread(this);
t.start();
}

public void run()
{
char ch;
for(;;)
{
try
{
repaint();
Thread.sleep(400);
ch=msg.charAt(0);
msg=msg.substring(1,msg.length());
msg=msg+ch;
}
catch(InterruptedException e)
{}
}
}
public void paint(Graphics g)
{
g.drawString(msg,100,50);
}
}
