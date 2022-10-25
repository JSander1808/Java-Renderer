package GUI;

public class Point3D {
    public double x;
    public double y;
    public double z;

    public Point3D(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setX(double x) {
        this.x = x;
    }
}
