package bai_14_thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_chen;

public class InsertionSort {
    public static void insertionSort(int[] array, int size) {
        for (int i = 1; i < size; i++) {
            int temp = array[i];
            int j = i - 1;
            while ((j >= 0) && (temp < array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 4, 3, 4, 6, 5, 1, 0, -3, -2, -1};
        System.out.println("Pre sort: ");
        for (int element: array) {
            System.out.print(element + "\t");
        }

        System.out.println();
        System.out.println("Sorted: ");
        insertionSort(array, array.length);
        for (int element: array) {
            System.out.print(element + "\t");
        }
    }
}
