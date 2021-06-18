package bai_1_introduction_to_java.bai_tap.ung_dung_doc_so_thanh_chu;

import java.util.Scanner;

public class ReadNumber {
    final static String[] ONES = {" ", " one", "two", " three", " four" , " five" , " six", " seven", " eight", " nine",
                        " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen",
                        " eighteen", " nineteen"};
    final static String[] TENS = {" ", " ", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};

    public static void readNumber(int num, String value) {
        System.out.print(num > 19 ? TENS[num / 10] + " " + ONES[num % 10] : ONES[num]);
        System.out.print(num > 0 ? value : "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any number: ");
        int num = sc.nextInt();

        while (num > 999) {
            System.out.println("Enter again (< 1000)!");
            num = sc.nextInt();
        }

        readNumber(((num / 100) % 10), " hundred and");
        readNumber(num % 10, "");
    }
}
