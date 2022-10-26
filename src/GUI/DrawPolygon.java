package GUI;

import java.awt.*;

public class DrawPolygon {

    public DrawPolygon(Graphics g, int focal, Color color, Point3D globalPosition, Point3D... point3Ds){
        Point[] points = new Point[point3Ds.length];
        for(int i = 0;i< point3Ds.length;i++){
            double x = (globalPosition.getX()+point3Ds[i].getX())-GUI.screenmiddle;
            double y = (globalPosition.getY()+point3Ds[i].getY())-GUI.screenmiddle;
            double z = (globalPosition.getZ()+point3Ds[i].getZ())-GUI.screenmiddle;

            double ScreenX;
            if(x>GUI.screenmiddle){
                double F = focal;
                double Fx = z;
                ScreenX = (F*x)/Fx;
            }else{
                double F = focal;
                double Fx = z;
                ScreenX = -(F*x)/Fx;
            }

            double ScreenY;
            if(y>GUI.screenmiddle){
                double F = focal;
                double Fy = z;
                ScreenY = (F*y)/Fy;
            }else{
                double F = focal;
                double Fy = z;
                ScreenY = -(F*y)/Fy;
            }
            points[i] = new Point((int) (ScreenX+GUI.screenmiddle), (int) (ScreenY+GUI.screenmiddle));
        }

        Polygon poly = new Polygon();
        for(Point p : points){
            poly.addPoint(p.x,p.y);
        }
        if(color == null){
            g.setColor(Color.red);
        }else{
            g.setColor(color);
        }
        g.drawPolygon(poly);
        System.out.println(globalPosition.getX()+" "+ globalPosition.getY()+" "+ globalPosition.getZ());
    }
}
