package bai_12_collection_framework.thuc_hanh.sap_xep_voi_comparator_va_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Kiên", 20, "QN");
        Student student2 = new Student("Tuấn", 25, "HN");
        Student student3 = new Student("Quân", 36, "DN");
        Student student4 = new Student("Lộc", 45, "HCM");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
//        Collections.sort(list);
//        for (Student e : list) {
//            System.out.println(e);
//        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list, ageComparator);
        for (Student e : list) {
            System.out.println(e);
        }
    }
}
