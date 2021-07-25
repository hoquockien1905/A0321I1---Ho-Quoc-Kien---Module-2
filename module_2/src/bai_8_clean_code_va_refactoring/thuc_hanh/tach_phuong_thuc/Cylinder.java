package bai_8_clean_code_va_refactoring.thuc_hanh.tach_phuong_thuc;

public class Cylinder {
    public static void main(String[] args) {
        System.out.println(getVolume(5, 2));
        System.out.println(getBaseArea(1));
        System.out.println(getPerimeter(2));
    }

    public static double getVolume(int radius, int height) {
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }
}
