package bai_7_abstract_class_va_interface.thuc_hanh.trien_khai_interface_comparator_de_so_sanh_cac_lop_hinh_hoc;

import bai_6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];

        circles[0] = new Circle(2.5);
        circles[1] = new Circle(5.2);
        circles[2] = new Circle(1.0);

        System.out.println("Pre - sort:");
        for (Circle o : circles) {
            System.out.println(o);
        }

        Arrays.sort(circles, new CircleComparator());

        System.out.println("After sorted:");
        for (Circle o : circles) {
            System.out.println(o);
        }
    }
}
