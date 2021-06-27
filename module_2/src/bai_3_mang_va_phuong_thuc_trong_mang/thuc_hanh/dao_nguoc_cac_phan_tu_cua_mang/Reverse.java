package bai_3_mang_va_phuong_thuc_trong_mang.thuc_hanh.dao_nguoc_cac_phan_tu_cua_mang;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array;
        int size = 0;

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
        Reverse rv = new Reverse();
        rv.reverse(array, size);
    }

    public void reverse(int[] array, int size) {
        System.out.println("Original Array: ");
        for (int o : array) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println("The Array was reversed: ");
        for (int i = 0; i < (size/2); i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
