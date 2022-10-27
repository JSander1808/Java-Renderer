package GUI;

public class Object {

    public Point3D globalPosition;
    public Point3D[][] point3Ds;

    public Object(Point3D globalPosition, Point3D[][] point3Ds){
        this.globalPosition=globalPosition;
        this.point3Ds=point3Ds;
    }

    public Point3D getGlobalPosition() {
        return globalPosition;
    }

    public Point3D[][] getPoint3Ds() {
        return point3Ds;
    }

    public void setGlobalPosition(Point3D globalPosition) {
        this.globalPosition = globalPosition;
    }

    public void setPoint3Ds(Point3D[][] point3Ds) {
        this.point3Ds = point3Ds;
    }
}
