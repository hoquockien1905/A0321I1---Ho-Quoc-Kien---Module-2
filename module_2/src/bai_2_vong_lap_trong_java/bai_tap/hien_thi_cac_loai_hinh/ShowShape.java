package bai_2_vong_lap_trong_java.bai_tap.hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class ShowShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;

        System.out.println("------------Menu-------------");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle" +
                "(top-left, top-right, bottom-left, bottom-right");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a: ");
                a = sc.nextInt();
                System.out.print("Enter b: ");
                b = sc.nextInt();
                while (a == b) {
                    System.err.print("a must be different from b and vice versa!\n");
                    System.out.println();
                    System.out.print("Enter again a: ");
                    a = sc.nextInt();
                    System.out.print("Enter again b: ");
                    b = sc.nextInt();
                }
                rectangle(a, b);
                break;
            case 2:
                System.out.println("1. top-left");
                System.out.println("2. top-right");
                System.out.println("3. bottom-left");
                System.out.println("4. bottom-right");
                System.out.println("5. exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                detailSquareTriangle(choice);
                break;
            case 3:
                System.out.print("Enter h: ");
                a = sc.nextInt();
                isoscelesTriangle(a);
                break;
            case 4:
                System.exit(4);
            default:
                System.err.println("Invalid input!");
        }
    }

    public static void detailSquareTriangle(int choice) {
        Scanner sc = new Scanner(System.in);
        int a;
        switch (choice) {
            case 1:
                System.out.print("Enter h: ");
                a = sc.nextInt();
                squareTriangleTopLeft(a);
                break;
            case 2:
                System.out.print("Enter h: ");
                a = sc.nextInt();
                squareTriangleTopRight(a);
                break;
            case 3:
                System.out.print("Enter h: ");
                a = sc.nextInt();
                squareTriangleBottomLeft(a);
                break;
            case 4:
                System.out.print("Enter h: ");
                a = sc.nextInt();
                squareTriangleBottomRight(a);
                break;
            case 5:
                System.exit(5);
            default:
                System.err.println("Invalid input!");
        }
    }

    public static void rectangle(int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void squareTriangleTopLeft(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = a; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void squareTriangleBottomRight(int a){
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= a; j++) {
                if (j >= a - i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void squareTriangleBottomLeft(int a) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void squareTriangleTopRight(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++){
                if (i >= 0 && j >= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void isoscelesTriangle(int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < (2 * h - 1); j++) {
                if ((j >= (h - i + 1)) && (j <= (h + i - 1))) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
