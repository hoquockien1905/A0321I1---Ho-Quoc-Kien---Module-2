package bai_15_xu_ly_ngoai_le_va_debug.bai_tap.su_dung_lop_illegaltriangleexception;

import java.util.Scanner;

public class Triangle {
    public Triangle(double firstSide, double secondSide, double thirdSide) throws IllegalTriangleException {
        if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0
                || (((firstSide + secondSide) < thirdSide)
                || ((firstSide + thirdSide) < thirdSide)
                || ((thirdSide + secondSide) < firstSide))) {
            throw new IllegalTriangleException("IllegalTriangleException");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = null;
        try {
            System.out.print("Enter a first side: ");
            double firstSide = scanner.nextDouble();
            System.out.print("Enter a second side: ");
            double secondSide = scanner.nextDouble();
            System.out.print("Enter a third side: ");
            double thirdSide = scanner.nextDouble();
            triangle = new Triangle(firstSide, secondSide, thirdSide);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
