package bai_7_abstract_class_va_interface.thuc_hanh.trien_khai_interface_comparable_cho_cac_lop_hinh_hoc;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];

        circles[0] = new ComparableCircle(1.5);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle("yellow", false, 2.5);

        System.out.println("Pre-sort: ");
        for (ComparableCircle o : circles) {
            System.out.println(o);
        }

        Arrays.sort(circles);

        System.out.println("After sorted:");
        for (ComparableCircle o : circles) {
            System.out.println(o);
        }
    }
}
