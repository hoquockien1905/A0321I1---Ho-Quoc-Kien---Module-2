package bai_2_vong_lap_trong_java.bai_tap.hien_thi_cac_so_nguyen_to_nho_hon_100;

public class PrimesLessThan100 {
    public static void main(String[] args) {
        String result = "";
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                result += i + "\t";
            }
        }

        System.out.printf("Prime numbers less than 100 are: \n%s", result);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
