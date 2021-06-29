package bai_4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_stop_watch;

public class Main {
    public static void main(String[] args) {

        StopWatch watch = new StopWatch();

        int[] array2 = new int[10000];

        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int)(Math.random() * 10000);
        }

        watch.start();
        for (int i = 0; i < array2.length; i++) {
            for (int j = array2.length - 1; j > i; j--) {
                if (array2[j] < array2[j - 1]) {
                    int temp = array2[j];
                    array2[j] = array2[j - 1];
                    array2[j - 1] = temp;
                }
            }
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + "\t");
        }
        watch.end();
        System.out.println();
        System.out.println(watch.toString());
        System.out.print("\nMillisecond of Bubble sort: " + watch.getElapsedTime());
    }
}
