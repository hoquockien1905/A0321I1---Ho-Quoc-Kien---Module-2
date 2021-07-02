package bai_6_ke_thua.bai_tap.lop_point2d_va_lop_point3d;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] array = new float[3];
        float[] arr = super.getXY();
        array[2] = getZ();
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        return array;
    }

    @Override
    public String toString() {
        return "Point3D {" + super.toString() + ", z = " + getZ() + '}';
    }
}
