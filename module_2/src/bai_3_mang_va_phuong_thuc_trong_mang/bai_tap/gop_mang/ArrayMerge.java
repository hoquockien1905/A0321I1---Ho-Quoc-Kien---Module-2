package bai_3_mang_va_phuong_thuc_trong_mang.bai_tap.gop_mang;

import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size1;
        int size2;
        do {
            System.out.print("Enter a size of array1: ");
            size1 = sc.nextInt();
            if (size1 > 20) {
                System.err.print("The size1 is a integer number <= 20!\n");
                System.out.println();
            }
            if (size1 < 1) {
                System.err.print("The size1 is a integer number > 0!\n");
                System.out.println();
            }
        } while (size1 > 20 || size1 < 1);

        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.print("array1[" + i + "] = ");
            array1[i] = sc.nextInt();
        }

        do {
            System.out.print("Enter a size of array2: ");
            size2 = sc.nextInt();
            if (size2 > 20) {
                System.err.print("The size2 is a integer number <= 20!\n");
                System.out.println();
            }
            if (size2 < 1) {
                System.err.print("The size2 is a integer number > 0!\n");
                System.out.println();
            }
        } while (size2 > 20 || size2 < 1);

        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.print("array2[" + i + "] = ");
            array2[i] = sc.nextInt();
        }
        int[] array3 = new int[size1 + size2];

        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }

        for (int i = 0; i < size2; i++) {
            array3[size1] = array2[i];
            size1++;
        }

        System.out.print("The size of array3 is: " + array3.length);
        System.out.println();
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + "\t");
        }
        System.out.println();

        ArrayMerge sw = new ArrayMerge();
        System.out.println("Array after sorting: ");
        for (int i = 0; i < array3.length - 1; i++) {
            for (int j = array3.length - 1; j > i; j--) {
                if (array3[j] < array3[j - 1]) {
                    sw.swap(array3, j);
                }
            }
        }
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + "\t");
        }
    }

    public void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }
}
