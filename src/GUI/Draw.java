package GUI;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {

    public Point3D[] front = new Point3D[]{new Point3D(-50,-50,50),new Point3D(50,-50,50),new Point3D(50,50,50),new Point3D(-50,50,50)};
    public Point3D[] leftsite = new Point3D[]{new Point3D(-50,-50,50),new Point3D(-50,-50,-50), new Point3D(-50,50,-50),new Point3D(-50,50,50)};
    public Point3D[] bottom = new Point3D[]{new Point3D(50,-50,50),new Point3D(-50,-50,50),new Point3D(-50,-50,-50),new Point3D(50,-50,-50)};
    public Point3D[] rightsite = new Point3D[]{new Point3D(50,-50,50),new Point3D(50,-50,-50),new Point3D(50,50,-50),new Point3D(50,50,50)};
    public Point3D[] top = new Point3D[]{new Point3D(-50,-50,50),new Point3D(-50,-50,-50),new Point3D(50,-50,-50),new Point3D(50,-50,50)};
    public Point3D[] back = new Point3D[]{new Point3D(-50,-50,-50),new Point3D(50,-50,-50),new Point3D(50,50,-50),new Point3D(-50,50,-50)};
    public CreateObject plate = new CreateObject(740,new Point3D(400,400,100),new Point3D[][]{front,back,leftsite,bottom,rightsite,top});

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0,0,GUI.SCREENWIDTH,GUI.SCREENHEIGHT);

        plate.setGraphics(g);
        plate.rotate(0,1,0);
        plate.rotate(1,0,0);
        plate.setColors(new Color[]{Color.red,Color.blue,Color.green,Color.orange,Color.yellow,Color.pink});
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        plate.render();

        repaint();
    }
}
