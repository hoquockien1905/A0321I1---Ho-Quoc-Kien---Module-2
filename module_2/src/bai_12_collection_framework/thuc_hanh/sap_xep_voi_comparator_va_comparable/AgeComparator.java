package bai_12_collection_framework.thuc_hanh.sap_xep_voi_comparator_va_comparable;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge().compareTo(o1.getAge());
    }
}
