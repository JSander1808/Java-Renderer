package GUI;

import java.awt.*;

public class CreateObject {

    public int focal = 0;
    public Object object;
    public Graphics g;
    public Color[] colors;

    public CreateObject(int focal, Object object){

        this.focal=focal;
        this.object=object;
    }

    public void render(){
        for(int i = 0;i< object.point3Ds.length;i++){
            if(colors == null){
                new DrawPolygon(g,focal,null, object.globalPosition, object.point3Ds[i]);
            }else{
                new DrawPolygon(g,focal,colors[i], object.globalPosition,object.point3Ds[i]);
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
        for(int i = 0;i< object.getPoint3Ds().length;i++){
            new RotatePolygon(rotationX,rotationY,rotationZ,object.getPoint3Ds()[i]);
        }
    }

    public void translate(double x, double y, double z){
        for(int i = 0;i<object.getPoint3Ds().length;i++){
            for(int j = 0;j<object.point3Ds[i].length;j++){
                object.getGlobalPosition().setX(object.getGlobalPosition().getX()+x);
                object.getGlobalPosition().setY(object.getGlobalPosition().getY()+y);
                object.getGlobalPosition().setZ(object.getGlobalPosition().getZ()+z);
            }
        }
    }

    public void setFocal(int focal) {
        this.focal = focal;
    }

    public Color[] getColors() {
        return colors;
    }

    public Graphics getG() {
        return g;
    }

    public int getFocal() {
        return focal;
    }
}
