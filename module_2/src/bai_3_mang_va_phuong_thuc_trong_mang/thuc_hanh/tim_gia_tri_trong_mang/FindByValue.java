package bai_3_mang_va_phuong_thuc_trong_mang.thuc_hanh.tim_gia_tri_trong_mang;

import java.util.Scanner;

public class FindByValue {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna",
                "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a name's student: ");
        String inputName = sc.nextLine().toLowerCase();
        boolean isExist = false;

        for (int i = 0; i < students.length; i++) {
            if (inputName.equals(students[i].toLowerCase())) {
                System.out.println("Position of " + students[i] + " in the list is " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found!");
        }
    }
}
