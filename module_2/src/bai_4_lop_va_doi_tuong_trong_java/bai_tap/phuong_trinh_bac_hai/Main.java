package bai_4_lop_va_doi_tuong_trong_java.bai_tap.phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        while (a == 0) {
            System.err.print("a # 0! Enter again: ");
            a = sc.nextDouble();
        }
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        System.out.println(equation.toString());
        System.out.println("delta = " + equation.getDiscriminant());
        if (equation.getDiscriminant() > (double) 0) {
            System.out.println("The equation has two roots: " + equation.getRoot1());
            System.out.println("\t\t\t\t\t\tand " + equation.getRoot2());
        } else if (equation.getDiscriminant() == (double) 0) {
            System.out.println("The equation has double root is: " + equation.getDoubleRoot());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}

