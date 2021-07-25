package bai_7_abstract_class_va_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public interface Resizeable {
    int percent = (int) Math.floor(1 + Math.random() * 100);
    void resize(double percent);
}
