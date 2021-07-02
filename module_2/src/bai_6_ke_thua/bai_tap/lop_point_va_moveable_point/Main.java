package bai_6_ke_thua.bai_tap.lop_point_va_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(0.54f, 2.2f);
        MoveablePoint moveablePoint = new MoveablePoint(point.getX(), point.getY(), 2.0f, 2.3f);

        System.out.println(point);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
