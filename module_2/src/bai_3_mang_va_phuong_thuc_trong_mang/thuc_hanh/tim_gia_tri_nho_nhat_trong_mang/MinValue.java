package bai_3_mang_va_phuong_thuc_trong_mang.thuc_hanh.tim_gia_tri_nho_nhat_trong_mang;

import java.util.Scanner;

public class MinValue {
    private static int size;
    private static int[] array;

    public void inputArray() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20 || size <= 0) {
                System.err.println("The size <= 20 and size > 0!\n");
                System.out.println();
            }
        } while (size > 20 || size <= 0);

        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = sc.nextInt();
        }
    }

    public int minValue() {
        inputArray();

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinValue min = new MinValue();

        System.out.print("Min value is: " + min.minValue());
    }
}
