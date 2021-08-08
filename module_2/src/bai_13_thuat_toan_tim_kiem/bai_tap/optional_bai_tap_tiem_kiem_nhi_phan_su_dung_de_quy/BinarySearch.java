package bai_13_thuat_toan_tim_kiem.bai_tap.optional_bai_tap_tiem_kiem_nhi_phan_su_dung_de_quy;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int value, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[left] > value) {
                return binarySearch(array, value, left, mid - 1);
            } else {
                return binarySearch(array, value, mid + 1, right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 1, 0, 2};
        Arrays.sort(array);
        for (int element: array) {
            System.out.print(element + "\t");
        }

        System.out.println();
        System.out.println(binarySearch(array, 5, 0, array.length - 1));
        System.out.println(binarySearch(array, 8, 0, array.length - 1));
    }
}
