package bai_3_mang_va_phuong_thuc_trong_mang.bai_tap.tim_phan_tu_lon_nhat_trong_mang_2_chieu;

import java.util.Scanner;

public class MaxValueIn2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row: ");
        int row = sc.nextInt();
        System.out.print("Enter column: ");
        int col = sc.nextInt();
        int[][] array2D = new int[row][col];

        MaxValueIn2D arr2D = new MaxValueIn2D();
        arr2D.input(array2D, row, col);
        System.out.println("Array is: ");
        arr2D.display(array2D, row, col);
        System.out.println();
        System.out.print("Max value in array 2D is: " +
                arr2D.maxValueInArray2D(array2D, row, col));
    }

    public int maxValueInArray2D(int[][] array, int row, int col) {
        int max = array[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public void input(int[][] array, int row, int col) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("array[" + i + "][" + j + "] = ");
                array[i][j] = sc.nextInt();
            }
        }
    }

    public void display(int[][] array, int row, int col) {
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + "\t");
            }
        }
    }
}
