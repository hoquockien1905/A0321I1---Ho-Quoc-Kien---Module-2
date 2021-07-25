package bai_8_clean_code_va_refactoring.thuc_hanh.tach_bien;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(7));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz(9));
    }

    public static String fizzBuzz(int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
