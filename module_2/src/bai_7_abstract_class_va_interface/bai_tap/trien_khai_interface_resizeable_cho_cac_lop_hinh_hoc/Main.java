package bai_7_abstract_class_va_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

import bai_6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        shapes[0] = new Rectangle(1.0, 2.0);
        shapes[1] = new Circle(5.0);

        Rectangle rectangle = (Rectangle) shapes[0];
        Circle circle = (Circle) shapes[1];

        System.out.println("Pre - resize");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println("After resize");
        rectangle.resize(Resizeable.percent);
        circle.resize(Resizeable.percent);
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
