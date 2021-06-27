package bai_3_mang_va_phuong_thuc_trong_mang.thuc_hanh.chuong_trinh_chuyen_doi_nhiet_do;

import java.util.Scanner;

public class ConvertTemperature {

    public double celsiusToFahrenheit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public double fahrenheitToCelsius() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertTemperature convert = new ConvertTemperature();

        System.out.println("------------Menu------------");
        System.out.println("1. Celsius to fahrenheit");
        System.out.println("2. Fahrenheit to celsius");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print(" = " + convert.celsiusToFahrenheit() + "°F");
                break;
            case 2:
                System.out.print(" = " + convert.fahrenheitToCelsius() + "°C");
                break;
            case 3:
                System.out.println("See you again!");
                System.exit(3);
            default:
                System.out.println("Invalid input!");
        }
    }
}
