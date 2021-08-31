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
        if (Employee.autoID >= 10 && Employee.autoID < 100) {
            this.idEmp = "EMP0" + Employee.autoID++;
        } else {
            this.idEmp = "EMP00" + Employee.autoID++;
        }
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String idCode, String fullName, String dateOfBirth, String gender, String phone, String email, Degree degree, Position position, double salary) {
        super(idCode, fullName, dateOfBirth, gender, phone, email);
        if (Employee.autoID >= 10 && Employee.autoID < 100) {
            this.idEmp = "EMP0" + Employee.autoID++;
        } else {
            this.idEmp = "EMP00" + Employee.autoID++;
        }
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public static int getAutoID() {
        return autoID;
    }

    public static void setAutoID(int autoID) {
        Employee.autoID = autoID;
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
        return idEmp + "," + fullName + "," + idCode +
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
            idCode = params[2];
            dateOfBirth = params[3];
            gender = params[4];
            phone = params[5];
            email = params[6];
            degree = new Degree(params[7]);
            position = new Position(params[8]);
            salary = Double.parseDouble(params[9]);
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
