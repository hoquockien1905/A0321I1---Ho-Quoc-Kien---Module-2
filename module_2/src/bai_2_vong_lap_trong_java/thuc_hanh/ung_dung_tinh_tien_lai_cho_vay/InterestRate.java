package bai_2_vong_lap_trong_java.thuc_hanh.ung_dung_tinh_tien_lai_cho_vay;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double money = sc.nextDouble();

        String formatMoney = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(money);

        System.out.print("Enter number of month: ");
        int month = sc.nextInt();

        System.out.print("Enter annual interest rate in percentage: ");
        double interestRate = sc.nextDouble();

        double total = 0;

        for (int i = 0; i < month; i++) {
            total += money * (interestRate/100) / 12 * month;
        }

        String formatTotal = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(total);

        System.out.println("Your investment amount is: " + formatMoney);
        System.out.println("The number of month is: " + month);
        System.out.printf("Your annual interest rate is: %.1f%s\n", interestRate, "%");
        System.out.println("Total of interest: " + formatTotal);
    }
}
