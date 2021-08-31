package case_study.models.person;

public abstract class Person {
    protected String fullName;
    protected String dateOfBirth;
    protected String gender;
    protected String idCode;
    protected String phone;
    protected String email;

    public Person() {
    }

    public Person(String idCode, String fullName, String dateOfBirth, String gender, String phone, String email) {
        this.idCode = idCode;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Full Name: " + fullName +
                ", ID Code: " + idCode +
                ", Date Of Birth: " + dateOfBirth +
                ", Gender: " + gender +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}
