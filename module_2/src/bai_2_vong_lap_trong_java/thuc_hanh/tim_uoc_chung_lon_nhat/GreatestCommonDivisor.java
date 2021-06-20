package bai_2_vong_lap_trong_java.thuc_hanh.tim_uoc_chung_lon_nhat;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gcd = 0;

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        if (a == 0 || b == 0) {
            gcd = a + b;
        } else {
            while (a != b) {
                gcd = (a > b) ? (a = a - b) : (b = b - a);
            }
        }
        System.out.print("Greatest common divisor is: " + gcd);
    }
}
