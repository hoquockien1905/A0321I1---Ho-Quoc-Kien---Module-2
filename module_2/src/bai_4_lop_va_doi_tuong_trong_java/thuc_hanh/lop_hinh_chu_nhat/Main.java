package bai_4_lop_va_doi_tuong_trong_java.thuc_hanh.lop_hinh_chu_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        System.out.print("Enter width: ");
        double width = sc.nextDouble();

        Rectangle rtg = new Rectangle(height, width);

        System.out.println(rtg.toString());
        System.out.printf("Area of Rectangle is: %.2f", rtg.getArea());
        System.out.printf("\nPerimeter of Rectangle is: %.2f", rtg.getPerimeter());
    }
}
