package bai_3_mang_va_phuong_thuc_trong_mang.bai_tap.chen_phan_tu_cho_mang;

import java.util.Scanner;

public class InsertElementForArray {
    private static int size;

    public int[] insertElement(int[] array) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter insertion position (starting from 0): ");
        int index = sc.nextInt();
        while (index > size - 1 || index < 0) {
            if (index > size - 1) {
                System.err.print("Index must be less than Size! Enter again: ");
            }
            if (index < 0) {
                System.err.print("Index must be greater than 0! Enter again: ");
            }
            index = sc.nextInt();
        }
        System.out.print("Enter insert value: ");
        int value = sc.nextInt();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        return array;
    }

    public void displayArray(int[] array) {
        for (int i = 0; i <= size; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.err.print("The size is a integer number <= 20!\n");
                System.out.println();
            }
        } while (size > 20);

        int[] array = new int[size + 1];

        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = sc.nextInt();
        }

        InsertElementForArray is = new InsertElementForArray();

        is.insertElement(array);
        System.out.println("Array after inserting");
        is.displayArray(array);

    }
}
