package bai_1_introduction_to_java.thuc_hanh.giai_phuong_trinh_bac_nhat;

import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Give a equation as ax + b = 0, please enter constants: ");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = sc.nextDouble();

        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        System.out.println("Your Linear Equation is: " + a + "x" + " + " + b + " = " + "0");

        if (a != 0) {
            double solution = -b / a;
            System.out.printf("The solution is: %.2f !", solution);
        }
    }
}
