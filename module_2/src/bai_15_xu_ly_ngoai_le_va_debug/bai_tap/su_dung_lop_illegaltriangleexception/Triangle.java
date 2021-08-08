package bai_15_xu_ly_ngoai_le_va_debug.bai_tap.su_dung_lop_illegaltriangleexception;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter first side: ");
            double firstSide = scanner.nextDouble();
            System.out.println("Enter second side: ");
            double secondSide = scanner.nextDouble();
            System.out.println("Enter third side: ");
            double thirdSide = scanner.nextDouble();
        } catch (Exception e) {
            throw new IllegalTriangleException
        }
    }
}
