package bai_6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();

        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        cylinder.setColor("yellow");
        cylinder.setRadius(4.2);
        cylinder.setHeight(5.6);
        System.out.println(cylinder);
        System.out.printf("Volume of Cylinder: %.2f\n", cylinder.getVolume());
    }
}
