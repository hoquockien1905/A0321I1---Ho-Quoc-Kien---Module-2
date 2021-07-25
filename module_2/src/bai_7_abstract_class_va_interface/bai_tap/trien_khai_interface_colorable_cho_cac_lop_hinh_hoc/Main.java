package bai_7_abstract_class_va_interface.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc;

import bai_6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();

        ((Rectangle) rectangle).howToColor();
    }
}
