package bai_4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Main {

    public static void main(String[] args) {

        Fan fan1 = new Fan(Fan.SLOW, false, 10, "yellow");
        Fan fan2 = new Fan(Fan.FAST, true, 5, "blue");

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
