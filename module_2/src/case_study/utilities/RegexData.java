package case_study.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexData {
    static final String ID_CODE = "^[0-9]{9}$";
    static final String NAME = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
    static final String GENDER = "(male|female|other)";
    static final String DATE_OF_BIRTH = "^([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/([0-9][0-9])?[0-9][0-9]$";
    static final String NUMBER_PHONE = "([(]\\d{2}[)])([-])([(]\\d{10}[)])";
    static final String EMAIL = "\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b";
    static final String DEGREE = "(college|university|intermediate|after university)";
    static final String POSITION = "^([A-Za-z]+)$";

    public boolean regexIdCode(String regex) {
        Pattern pattern = Pattern.compile(ID_CODE);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexDateOfBirth(String regex) {
        Pattern pattern = Pattern.compile(DATE_OF_BIRTH);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexName(String regex) {
        Pattern pattern = Pattern.compile(NAME);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexGender(String regex) {
        Pattern pattern = Pattern.compile(GENDER);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexNumberPhone(String regex) {
        Pattern pattern = Pattern.compile(NUMBER_PHONE);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexDegree(String regex) {
        Pattern pattern = Pattern.compile(DEGREE);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public boolean regexPosition(String regex) {
        Pattern pattern = Pattern.compile(POSITION);
        Matcher matcher = pattern.matcher(regex);

        return matcher.matches();
    }

}
