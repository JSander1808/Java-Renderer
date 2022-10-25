package GUI;

public class RotatePolygon {

    public RotatePolygon(int rotationX, int rotationY, int rotationZ, Point3D... point3Ds){
        Point3D[] newPoint = new Point3D[point3Ds.length];
        for(int i = 0;i< point3Ds.length;i++){
            newPoint[i] = point3Ds[i];
            if(rotationX>0){
                double x = point3Ds[i].getX();
                double y = point3Ds[i].getY();
                double z = point3Ds[i].getZ();
                double yr = (y*Math.cos(Math.toRadians(rotationX)))+(z*Math.sin(Math.toRadians(rotationX)));
                double zr = (y*-Math.sin(Math.toRadians(rotationX)))+(z*Math.cos(Math.toRadians(rotationX)));
                newPoint[i]=new Point3D(x,yr,zr);
            }
            if(rotationY>0){
                double x = point3Ds[i].getX();
                double y = point3Ds[i].getY();
                double z = point3Ds[i].getZ();
                double xr = (x*Math.cos(Math.toRadians(rotationY)))+(z*Math.sin(Math.toRadians(rotationY)));
                double zr = (x*-Math.sin(Math.toRadians(rotationY)))+(z*Math.cos(Math.toRadians(rotationY)));
                newPoint[i]=new Point3D(xr,y,zr);
            }
            if(rotationZ>0){
                double x = point3Ds[i].getX();
                double y = point3Ds[i].getY();
                double z = point3Ds[i].getZ();
                double xr = (x*Math.cos(Math.toRadians(rotationZ)))+(y*Math.sin(Math.toRadians(rotationZ)));
                double yr = (x*-Math.sin(Math.toRadians(rotationZ)))+(y*Math.cos(Math.toRadians(rotationZ)));
                newPoint[i] = new Point3D(xr,yr,z);
            }
            point3Ds[i] = newPoint[i];
            System.out.println(point3Ds[i].getX()+" "+point3Ds[i].getY()+" "+point3Ds[i].getZ());
            System.out.println(newPoint[i].getX()+" "+newPoint[i].getY()+" "+newPoint[i].getZ());
        }
    }
}
