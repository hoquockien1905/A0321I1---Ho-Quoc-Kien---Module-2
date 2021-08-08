package bai_13_thuat_toan_tim_kiem.thuc_hanh.cai_dat_tim_kiem_nhi_phan_khong_de_quy;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a size of array: ");
        int size = scanner.nextInt();
        int[] arrayInteger = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            arrayInteger[i] = scanner.nextInt();
        }

        System.out.print("Enter your number: ");
        int yourNumber = scanner.nextInt();

        System.out.println(binarySeach(arrayInteger, yourNumber));
    }

    public static boolean binarySeach (int[] array, int yourNumber) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == yourNumber) {
                return true;
            } else if (array[mid] > yourNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
