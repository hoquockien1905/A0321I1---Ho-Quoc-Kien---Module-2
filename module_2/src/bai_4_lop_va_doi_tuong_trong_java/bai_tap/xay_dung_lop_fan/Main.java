package bai_4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Main {

    public static void main(String[] args) {
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;

        Fan fan1 = new Fan(SLOW, false, 10, "yellow");
        Fan fan2 = new Fan(FAST, true, 5, "blue");

        fan1.setOn(true);
        fan1.setSpeed(fan1.getFAST());
        fan2.setSpeed(fan2.getSLOW());

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

        fan1.setOn(false);
        System.out.println(fan1.toString());

        fan1.setOn(true);
        fan1.setSpeed(fan1.getMEDIUM());
        fan1.setColor("Red");

        System.out.println(fan1.toString());
    }
}
