package GUI;

import java.awt.*;

public class CreateObject {

    public int focal = 0;
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
            if(colors == null){
                new DrawPolygon(g,focal,null, globalPosition,point3Ds[i]);
            }else{
                new DrawPolygon(g,focal,colors[i], globalPosition,point3Ds[i]);
            }
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

    public void translate(double x, double y, double z){
        for(int i = 0;i<point3Ds.length;i++){
            for(int j = 0;j<point3Ds[i].length;j++){
                globalPosition.setX(globalPosition.getX()+x);
                globalPosition.setY(globalPosition.getY()+y);
                globalPosition.setZ(globalPosition.getZ()+z);
            }
        }
    }
}
