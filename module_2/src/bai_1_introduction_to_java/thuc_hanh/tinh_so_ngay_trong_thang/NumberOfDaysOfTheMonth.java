package bai_1_introduction_to_java.thuc_hanh.tinh_so_ngay_trong_thang;

import java.util.Scanner;

public class NumberOfDaysOfTheMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result;

        System.out.print("Enter any month: ");
        byte month = sc.nextByte();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result = "Month " + month + " has 31 days";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                result = "Month " + month + " has 30 days";
                break;
            case 2:
                result = "Month " + month + " has 28 or 29 days";
                break;
            default:
                result = "Invalid input!";
                break;
        }

        System.out.println(result);
    }
}
