package bai_18_string_regex.bai_tap.validate_ten_cua_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    static final String CLASS_NAME_REGEX = "([CAP])\\d{4}[G-M]";
    static final String[] INVALID_VALUE = {"M0318G", "P0323A"};
    static final String[] VALID_VALUE = {"C0318G"};

    public ValidateClassName() {
    }

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        ValidateClassName validateClassName = new ValidateClassName();
        for (String className: INVALID_VALUE) {
            boolean isValid = validateClassName.validate(className);
            System.out.println(className + " is valid: " + isValid);
        }

        for (String className: VALID_VALUE) {
            boolean isValid = validateClassName.validate(className);
            System.out.println(className + " is valid: " + isValid);
        }
    }
}
