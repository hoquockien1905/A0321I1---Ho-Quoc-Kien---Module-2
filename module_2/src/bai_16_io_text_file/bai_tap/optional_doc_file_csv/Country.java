package bai_16_io_text_file.bai_tap.optional_doc_file_csv;

public class Country {
    private String ipStart;
    private String ipEnd;
    private String x;
    private String y;
    private String countryCode;
    private String countryName;

    public Country() {
    }

    public Country(String ipStart, String ipEnd, String x, String y, String countryCode, String countryName) {
        this.ipStart = ipStart;
        this.ipEnd = ipEnd;
        this.x = x;
        this.y = y;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getIpStart() {
        return ipStart;
    }

    public void setIpStart(String ipStart) {
        this.ipStart = ipStart;
    }

    public String getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(String ipEnd) {
        this.ipEnd = ipEnd;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return this.ipStart +
                ", " + this.ipEnd +
                ", " + this.x +
                ", " + this.y +
                ", " + this.countryCode +
                ", " + this.countryName;
    }
}
