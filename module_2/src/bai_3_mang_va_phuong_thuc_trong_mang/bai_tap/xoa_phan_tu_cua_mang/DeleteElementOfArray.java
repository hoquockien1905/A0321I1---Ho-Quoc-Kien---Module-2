package bai_3_mang_va_phuong_thuc_trong_mang.bai_tap.xoa_phan_tu_cua_mang;

import java.util.Scanner;

public class DeleteElementOfArray {
    public static int size;

    public void valueToDelete(int[] array) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value to delete: ");
        int value = sc.nextInt();
        boolean check = false;
        for (int i = 0; i < size;) {
            if (array[i] == value) {
                indexToDelete(array, i);
                check = true;
            } else {
                i++;
            }
        }
        if (!check) {
            System.err.println("Not found!");
        }
    }

    public void displayArray(int[] array) {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        if (size == 0) {
            System.err.println("\nEmpty array!");
        }
    }

    public void indexToDelete(int[] array, int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {

        DeleteElementOfArray delElement = new DeleteElementOfArray();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.err.print("The size is a integer number <= 20!\n");
                System.out.println();
            }
        } while (size > 20);

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        delElement.displayArray(array);

        System.out.println();

        delElement.valueToDelete(array);
        System.out.println();
        System.out.println("Array after deleting:");
        delElement.displayArray(array);
    }
}
