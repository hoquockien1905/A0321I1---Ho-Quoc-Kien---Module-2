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

        double delta = equation.getDiscriminant();
        double root1 = equation.getRoot1();
        double root2 = equation.getRoot2();
        double doubleRoot = equation.getDoubleRoot();
        System.out.println("delta = " + delta);
        if (equation.getDiscriminant() > (double) 0) {
            System.out.println("The equation has two roots: " + root1);
            System.out.println("\t\t\t\t\t\tand " + root2);
        } else if (equation.getDiscriminant() == (double) 0) {
            System.out.println("The equation has double root is: " + doubleRoot);
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}

