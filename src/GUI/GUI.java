package GUI;

import javax.swing.*;

import java.awt.*;

import static jdk.jfr.internal.consumer.EventLog.stop;

public class GUI{

    public static int screenwidth = 800;
    public static int screenheight = 800;
    public static int screenmiddle = screenwidth/4+screenheight/4;
    public static JFrame frame;

    public GUI(){
        frame = new JFrame("3D - Renderer");
        frame.setSize(screenwidth,screenheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel draw = new Draw();
        draw.setBounds(0,0,GUI.screenwidth,GUI.screenheight);


        frame.add(draw);
        frame.setVisible(true);
    }
}
