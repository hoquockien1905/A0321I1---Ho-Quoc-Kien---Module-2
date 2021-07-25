package bai_6_ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import bai_6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape("red", false);
        Triangle triangle = new Triangle(shape.getColor(), shape.isFilled(), 5.0f, 4.0f, 3.0f);

        System.out.println("Area = " + triangle.getArea());
        System.out.println("Perimeter = " + triangle.getPerimeter());
    }
}
