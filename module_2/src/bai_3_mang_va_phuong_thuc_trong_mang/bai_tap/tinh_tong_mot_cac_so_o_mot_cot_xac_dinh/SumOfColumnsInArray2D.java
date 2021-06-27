package bai_3_mang_va_phuong_thuc_trong_mang.bai_tap.tinh_tong_mot_cac_so_o_mot_cot_xac_dinh;

import java.util.Scanner;

public class SumOfColumnsInArray2D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row: ");
        int row = sc.nextInt();
        System.out.print("Enter column: ");
        int col = sc.nextInt();
        int[][] array2D = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("array[" + i + "][" + j + "] = ");
                array2D[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < col; j++) {
                System.out.print(array2D[i][j] + "\t");
            }
        }

        SumOfColumnsInArray2D s = new SumOfColumnsInArray2D();
        System.out.print("Sum of column is: " +
                s.sum(array2D, row, col));
    }

    public int sum(int[][] array, int row, int col) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a column to sum (starting from 0): ");
        int indexCol = sc.nextInt();
        while (indexCol >= col || indexCol < 0) {
            if (indexCol >= col) {
                System.err.print("The index of column < " + col + " : ");
                indexCol = sc.nextInt();
            }
            if (indexCol < 0) {
                System.err.print("The index of column >= 0: ");
                indexCol = sc.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (indexCol == j){
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }
}
