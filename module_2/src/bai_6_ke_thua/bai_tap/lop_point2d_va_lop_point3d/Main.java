package bai_6_ke_thua.bai_tap.lop_point2d_va_lop_point3d;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(0.5f, 0.7f);
        Point3D point3D = new Point3D(point2D.getX(), point2D.getY(), 9.2f);

        System.out.println(point2D);
        System.out.println(point3D);
        for (int i = 0; i < point2D.getXY().length; i++) {
            System.out.print(point2D.getXY()[i] + "\t");
        }

    }
}
