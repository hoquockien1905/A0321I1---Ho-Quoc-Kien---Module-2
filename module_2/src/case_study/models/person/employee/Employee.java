package case_study.models.person.employee;

import case_study.models.person.Person;

public class Employee extends Person {
    private static int autoID = 1;
    private String idEmp = "EMP00";
    protected Degree degree;
    protected Position position;
    private double salary;

    public Employee() {
    }

    public Employee(Degree degree, Position position, double salary) {
        this.idEmp = "EMP00" + Employee.autoID++;
        if (Employee.autoID > 9 && Employee.autoID < 100) {
            this.idEmp = "EMP0" + Employee.autoID++;
        }
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String idCode, String fullName, String dateOfBirth, String gender, String phone, String email, Degree degree, Position position, double salary) {
        super(idCode, fullName, dateOfBirth, gender, phone, email);
        this.idEmp = "EMP00" + Employee.autoID++;
        if (Employee.autoID > 9 && Employee.autoID < 100) {
            this.idEmp = "EMP0" + Employee.autoID++;
        }
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFileLine() {
        return idEmp + "," + fullName +
                "," + dateOfBirth + "," + gender +
                "," + phone + "," + email +
                "," + degree + "," + position +
                "," + salary + "\n";
    }

    public void parse(String line) {
        String[] params = line.split(",");
        try {
            idEmp = params[0];
            fullName = params[1];
            dateOfBirth = params[2];
            gender = params[3];
            phone = params[4];
            email = params[5];
            degree = new Degree(params[6]);
            position = new Position(params[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    @Override
    public String toString() {
        return  "Employee {" +
                "ID: " + idEmp +
                ", " +
                super.toString() +
                ", Degree: " + degree +
                ", Position: " + position +
                ", Salary: " + salary +
                '}';
    }
}
