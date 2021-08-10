package bai_15_xu_ly_ngoai_le_va_debug.bai_tap.su_dung_lop_illegaltriangleexception;

public class IllegalTriangleException extends Exception {
    private String msg;

    public IllegalTriangleException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
