package bai_2_vong_lap_trong_java.bai_tap.hien_thi_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class ShowTheFirstPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of primes: ");
        int numbers = sc.nextInt();

        while (numbers <= 0) {
            System.out.print("Enter again: ");
            numbers = sc.nextInt();
        }

        int count = 0;
        int n = 2;
        while (count < numbers) {
            if (isPrime(n)) {
                System.out.print(n + "\t");
                count++;
            }
            n++;
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
