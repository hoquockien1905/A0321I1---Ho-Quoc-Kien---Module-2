package bai_2_vong_lap_trong_java.thuc_hanh.ung_dung_menu_ve_hinh;

import java.util.Scanner;

public class DrawingMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------Menu---------");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a: ");
                int a = sc.nextInt();
                triangle(a);
                break;
            case 2:
                System.out.print("Enter a: ");
                a = sc.nextInt();
                square(a);
                break;
            case 3:
                System.out.print("Enter a: ");
                a = sc.nextInt();
                System.out.print("Enter b: ");
                int b = sc.nextInt();
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
            case 0:
                System.out.println("See you later!");
                System.exit(0);
            default:
                System.err.println("No choice! Enter again, please!");
        }
    }

    public static void triangle(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = a; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void square(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(" * ");
            }
            System.out.println();
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
}
