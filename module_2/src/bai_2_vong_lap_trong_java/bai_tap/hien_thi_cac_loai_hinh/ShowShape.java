package bai_2_vong_lap_trong_java.bai_tap.hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class ShowShape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width;
        int height;

        ShowShape check = new ShowShape();
        ShowShape show = new ShowShape();

        int choice = check.checkInputMenu();

        switch (choice) {
            case 1:
                System.out.print("WIDTH must be different from HEIGHT and vice versa!\n");
                System.out.println();
                width = check.checkWidth();
                height = check.checkHeight();
                show.rectangle(width, height);
                break;
            case 2:
                System.out.println("1. top-left");
                System.out.println("2. top-right");
                System.out.println("3. bottom-left");
                System.out.println("4. bottom-right");
                System.out.println("5. exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                show.detailSquareTriangle(choice);
                break;
            case 3:
                height = check.checkHeight();
                show.isoscelesTriangle(height);
                break;
            case 4:
                System.exit(4);
            default:
                System.err.println("Invalid input!");
        }
    }

    public int checkInputMenu() {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("------------Menu-------------");
                System.out.println("1. Print the rectangle");
                System.out.println("2. Print the square triangle" +
                        "(top-left, top-right, bottom-left, bottom-right");
                System.out.println("3. Print isosceles triangle");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice <= 4 && choice >=1) {
                    break;
                }
            } catch (Exception e){
                System.err.println("Enter again, please! ");
            }
        }
        return choice;
    }

    public int checkWidth() {
        int check;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter width: ");
                check = Integer.parseInt(sc.nextLine());
                if (check > 0) {
                    break;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }

    public int checkHeight() {
        int check;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter height: ");
                check = Integer.parseInt(sc.nextLine());
                if (check > 0) {
                    break;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }


    public void detailSquareTriangle(int choice) {
        Scanner sc = new Scanner(System.in);
        int height;
        switch (choice) {
            case 1:
                System.out.print("Enter height: ");
                height = sc.nextInt();
                squareTriangleTopLeft(height);
                break;
            case 2:
                System.out.print("Enter height: ");
                height = sc.nextInt();
                squareTriangleTopRight(height);
                break;
            case 3:
                System.out.print("Enter height: ");
                height = sc.nextInt();
                squareTriangleBottomLeft(height);
                break;
            case 4:
                System.out.print("Enter height: ");
                height = sc.nextInt();
                squareTriangleBottomRight(height);
                break;
            case 5:
                System.exit(5);
            default:
                System.err.println("Invalid input!");
        }
    }

    public void rectangle(int a, int b) {
        Scanner sc = new Scanner(System.in);
        while (a == b) {
            System.err.println("WIDTH <> HEIGHT!\n");
            System.out.println();
            System.out.print("Enter width: ");
            a = sc.nextInt();
            System.out.print("Enter height: ");
            b = sc.nextInt();
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public void squareTriangleTopLeft(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = a; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public void squareTriangleBottomRight(int a){
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

    public void squareTriangleBottomLeft(int a) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void squareTriangleTopRight(int a) {
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

    public void isoscelesTriangle(int h) {
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
