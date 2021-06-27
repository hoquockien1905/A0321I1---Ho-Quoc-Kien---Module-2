package bai_3_mang_va_phuong_thuc_trong_mang.thuc_hanh.tim_gia_tri_lon_nhat_trong_mang;

import bai_3_mang_va_phuong_thuc_trong_mang.thuc_hanh.dao_nguoc_cac_phan_tu_cua_mang.Reverse;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array;

        int size;

        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.err.print("The size is a integer number <= 20!\n");
                System.out.println();
            }
        } while (size > 20);
        array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = sc.nextInt();
        }

        System.out.println("Your Array: ");
        for (int o : array) {
            System.out.print(o + "\t");
        }

        int max = array[0];
        for (int o : array) {
            if (max < o) {
                max = o;
            }
        }

        System.out.println("\nMax value is: " + max);
    }
}
