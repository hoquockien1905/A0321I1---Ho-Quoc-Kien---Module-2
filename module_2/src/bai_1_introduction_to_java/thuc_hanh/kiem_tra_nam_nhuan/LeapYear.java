package bai_1_introduction_to_java.thuc_hanh.kiem_tra_nam_nhuan;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any year: ");
        int year = sc.nextInt();

        if (year <= 0) {
            System.out.println("Invalid input!");
        } else {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    System.out.println(year + " is not a leap year");
                    if (year % 400 == 0) {
                        System.out.println(year + " is a leap year");
                    } else {
                        System.out.println(year + " is not a leap year");
                    }
                } else {
                    System.out.println(year + " is a leap year");
                }
            } else {
                System.out.println(year + " is not a leap year");
            }
        }
    }
}
