package bai_5_access_modifier.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();

        double radius = circle.getRadius();
        double area = circle.getArea();

        System.out.println(radius);
        System.out.println(area);
    }
}
