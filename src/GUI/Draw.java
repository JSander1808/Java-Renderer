package GUI;

import javax.swing.*;
import java.awt.*;

import static jdk.jfr.internal.consumer.EventLog.stop;

public class Draw extends JPanel implements Runnable{

    public Point3D[] front = new Point3D[]{new Point3D(-50,-50,50),new Point3D(50,-50,50),new Point3D(50,50,50),new Point3D(-50,50,50)};
    public Point3D[] leftsite = new Point3D[]{new Point3D(-50,-50,50),new Point3D(-50,-50,-50), new Point3D(-50,50,-50),new Point3D(-50,50,50)};
    public Point3D[] bottom = new Point3D[]{new Point3D(50,-50,50),new Point3D(-50,-50,50),new Point3D(-50,-50,-50),new Point3D(50,-50,-50)};
    public Point3D[] rightsite = new Point3D[]{new Point3D(50,-50,50),new Point3D(50,-50,-50),new Point3D(50,50,-50),new Point3D(50,50,50)};
    public Point3D[] top = new Point3D[]{new Point3D(-50,-50,50),new Point3D(-50,-50,-50),new Point3D(50,-50,-50),new Point3D(50,-50,50)};
    public Point3D[] back = new Point3D[]{new Point3D(-50,-50,-50),new Point3D(50,-50,-50),new Point3D(50,50,-50),new Point3D(-50,50,-50)};

    public Point3D[] front1 = new Point3D[]{new Point3D(-50,-50,50),new Point3D(50,-50,50),new Point3D(50,50,50),new Point3D(-50,50,50)};
    public Point3D[] leftsite1 = new Point3D[]{new Point3D(-50,-50,50),new Point3D(-50,-50,-50), new Point3D(-50,50,-50),new Point3D(-50,50,50)};
    public Point3D[] bottom1 = new Point3D[]{new Point3D(50,-50,50),new Point3D(-50,-50,50),new Point3D(-50,-50,-50),new Point3D(50,-50,-50)};
    public Point3D[] rightsite1 = new Point3D[]{new Point3D(50,-50,50),new Point3D(50,-50,-50),new Point3D(50,50,-50),new Point3D(50,50,50)};
    public Point3D[] top1 = new Point3D[]{new Point3D(-50,-50,50),new Point3D(-50,-50,-50),new Point3D(50,-50,-50),new Point3D(50,-50,50)};
    public Point3D[] back1 = new Point3D[]{new Point3D(-50,-50,-50),new Point3D(50,-50,-50),new Point3D(50,50,-50),new Point3D(-50,50,-50)};
    public CreateObject plate = new CreateObject(1000,new Point3D(400,400,100),new Point3D[][]{front,back,leftsite,bottom,rightsite,top});
    public CreateObject cube = new CreateObject(150,new Point3D(  300,400,00),new Point3D[][]{front1,back1,leftsite1,rightsite1,bottom1,top1});
    public boolean running;
    private Thread thread;
    private int sleepIndex = 16;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GUI.screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        GUI.screenheight=Toolkit.getDefaultToolkit().getScreenSize().height;

        g.setColor(Color.black);
        g.fillRect(0,0,GUI.screenwidth,GUI.screenheight);

        plate.setGraphics(g);
        cube.setGraphics(g);
        cube.rotate(0,1,0);
        plate.rotate(0,1,0);
        plate.translate(0.01,0,0);
        plate.translate(0,0,-0.05);
        plate.setColors(new Color[]{Color.red,Color.blue,Color.green,Color.orange,Color.yellow,Color.pink});
        try {
            Thread.sleep(sleepIndex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cube.render();
        plate.render();

        repaint();
        start();
    }

    private synchronized void start() {
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks ;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running) {
            long now = System.nanoTime();
            delta += (lastTime - now) / ns;
            lastTime = now;
            if(delta >= 1) {
                updates++;
                delta--;
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                GUI.frame.setTitle("3D - Renderer        FPS:"+frames);
                updates = 0;
                frames = 0;
            }
            try {
                Thread.sleep(sleepIndex);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        stop();
    }
}
