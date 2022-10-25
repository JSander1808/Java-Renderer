package GUI;

import java.awt.*;

public class CreateObject {

    public int focal;
    public Point3D globalPosition;
    public Point3D[][] point3Ds;
    public Graphics g;
    public Color[] colors;

    public CreateObject(int focal, Point3D globalPosition, Point3D[]... point3Ds){
        this.focal=focal;
        this.globalPosition=globalPosition;
        this.point3Ds=point3Ds;
    }

    public void render(){
        for(int i = 0;i< point3Ds.length;i++){
            new DrawPolygon(g,focal,colors[i], globalPosition,point3Ds[i]);
        }
    }

    public void setGraphics(Graphics g){
        this.g=g;
    }

    public void setColors(Color[] colors){
        this.colors=colors;
    }

    public void rotate(int rotationX, int rotationY, int rotationZ){
        for(int i = 0;i< point3Ds.length;i++){
            new RotatePolygon(rotationX,rotationY,rotationZ,point3Ds[i]);
        }
    }
}
