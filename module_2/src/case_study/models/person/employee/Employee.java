package case_study.models.person.employee;

import case_study.models.person.Person;

public class Employee extends Person {
    private String idEmp;
    protected Degree degree;
    protected Position position;
    private String salary;

    public Employee() {
    }

    public Employee(String idEmp, Degree degree, Position position, String salary) {
        this.idEmp = idEmp;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String fullName, String dateOfBirth, boolean gender, String idCode, String phone, String email, String idEmp, Degree degree, Position position, String salary) {
        super(fullName, dateOfBirth, gender, idCode, phone, email);
        this.idEmp = idEmp;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
