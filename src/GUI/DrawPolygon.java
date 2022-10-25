package GUI;

import java.awt.*;

public class DrawPolygon {

    public DrawPolygon(Graphics g, int focal, Color color, Point3D globalPosition, Point3D... point3Ds){
        Point[] points = new Point[point3Ds.length];
        for(int i = 0;i< point3Ds.length;i++){
            double x = (globalPosition.getX()+point3Ds[i].getX())-GUI.SCREENMIDDLE;
            double y = (globalPosition.getY()+point3Ds[i].getY())-GUI.SCREENMIDDLE;
            double z = (globalPosition.getZ()+point3Ds[i].getZ())-GUI.SCREENMIDDLE;

            double ScreenX;
            if(x>GUI.SCREENMIDDLE){
                double F = focal;
                double Fx = z;
                ScreenX = (F*x)/Fx;
            }else{
                double F = focal;
                double Fx = z;
                ScreenX = -(F*x)/Fx;
            }

            double ScreenY;
            if(y>GUI.SCREENMIDDLE){
                double F = focal;
                double Fy = z;
                ScreenY = (F*y)/Fy;
            }else{
                double F = focal;
                double Fy = z;
                ScreenY = -(F*y)/Fy;
            }
            points[i] = new Point((int) (ScreenX+GUI.SCREENMIDDLE), (int) (ScreenY+GUI.SCREENMIDDLE));
        }

        Polygon poly = new Polygon();
        for(Point p : points){
            poly.addPoint(p.x,p.y);
        }
        g.setColor(color);
        g.fillPolygon(poly);
    }
}
