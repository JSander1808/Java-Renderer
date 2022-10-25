package GUI;

import javax.swing.*;

public class GUI {

    public static final int SCREENWIDTH = 800;
    public static final int SCREENHEIGHT = 800;
    public static final int SCREENMIDDLE = SCREENWIDTH/4+SCREENHEIGHT/4;

    public GUI(){
        JFrame frame = new JFrame("3D - Renderer");
        frame.setSize(SCREENWIDTH,SCREENHEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel draw = new Draw();
        draw.setBounds(0,0,GUI.SCREENWIDTH,GUI.SCREENHEIGHT);


        frame.add(draw);
        frame.setVisible(true);
    }
}
