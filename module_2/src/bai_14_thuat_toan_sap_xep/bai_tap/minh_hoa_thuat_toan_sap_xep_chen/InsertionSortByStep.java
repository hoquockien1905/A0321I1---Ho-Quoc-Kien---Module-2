package bai_14_thuat_toan_sap_xep.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }
        System.out.print("\nYour array: \n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

        insertionSort(size, array);
        System.out.println();

        System.out.println("\nSorted Array: ");
        for (int element: array) {
            System.out.print(element + "\t");
        }
    }

    public static void insertionSort(int size, int[] array) {
        for (int i = 1; i < size; i++) {
            System.out.println();
            System.out.println("i = " + i);
            int j = i - 1;
            System.out.println("j = i - 1 = " + j);
            int temp = array[i];
            System.out.println("temp = array[i] = " + array[i]);
            while ((j >= 0) && (temp < array[j])) {
                System.out.println();
                System.out.println("j = " + j + "\n" + "temp = " + temp);
                System.out.println("if (j >= 0) && (temp < array[j])");
                System.out.println("Swap " + array[j + 1] + " with " + array[j]);
                array[j + 1] = array[j];
                j--;
            }
            System.out.println("Swap " + array[j + 1] + " with " + temp );
            array[j + 1] = temp;
        }
    }
}
