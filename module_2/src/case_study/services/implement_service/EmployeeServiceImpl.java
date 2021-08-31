package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.person.employee.Degree;
import case_study.models.person.employee.Employee;
import case_study.models.person.employee.Position;
import case_study.services.interface_service.EmployeeService;
import case_study.utilities.RegexData;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    static FuramaController furamaController = new FuramaController();
    static RegexData regexData = new RegexData();
    private static int choice;

    public void saveData() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\employee.csv");

            for (Employee employee : employeeList) {
                String line = employee.getFileLine();
                byte[] bytes = line.getBytes("UTF-8");
                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFile() {
        FileInputStream fileInputStream = null;
        InputStreamReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\employee.csv");
            fileReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(fileReader);
            employeeList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Employee employee = new Employee();
                employee.parse(line);
                employeeList.add(employee);
            }
            Employee.setAutoID(employeeList.size() + 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void displayListEmp() {
        System.out.println("========= Employee List ========");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        furamaController.displayMenuEmployee();
    }

    public void addNewEmp() {
        System.out.print("Enter ID Code: ");
        String idCode = scanner.nextLine();
        idCode = regexIDCode(idCode);
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        name = regexName(name);
        System.out.print("Enter Date of birth: ");
        String dateOfBirth = scanner.nextLine();
        dateOfBirth = regexDateOfBirth(dateOfBirth);
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        gender = regexGender(gender);
        System.out.print("Enter Number phone: ");
        String phone = scanner.nextLine();
        phone = regexNumberPhone(phone);
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        email = regexEmail(email);
        System.out.print("Enter Degree: ");
        String degree = scanner.nextLine();
        degree = regexDegree(degree);
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();
        position = regexPosition(position);
        double salary = regexSalary();

        employeeList.add(new Employee(idCode, name, dateOfBirth, gender, phone, email, new Degree(degree), new Position(position), salary));
        System.out.println("A new employee has just been added!");
        saveData();

        if (continues()) {
            addNewEmp();
        } else {
            furamaController.displayMenuEmployee();
        }
    }

    private double regexSalary() {
        double salary;
        while (true) {
            try {
                System.out.print("Enter Salary: ");
                salary = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid!");
            }
        }
        return salary;
    }

    private String regexPosition(String position) {
        while (!regexData.regexPosition(position)) {
            System.out.print("Enter Position again: ");
            position = scanner.nextLine();
        }
        return position;
    }

    private String regexDegree(String degree) {
        while (!regexData.regexDegree(degree)) {
            System.out.print("Enter Degree again (college/university/intermediate/after university): ");
            degree = scanner.nextLine();
        }
        return degree;
    }

    public String regexEmail(String email) {
        while (!regexData.regexEmail(email)) {
            System.out.print("Enter Email again: ");
            email = scanner.nextLine();
        }
        return email;
    }

    public String regexNumberPhone(String phone) {
        while (!regexData.regexNumberPhone(phone)) {
            System.out.print("Enter Number phone again ((84)-(0123456789)): ");
            phone = scanner.nextLine();
        }
        return phone;
    }

    public String regexGender(String gender) {
        while (!regexData.regexGender(gender)) {
            System.out.print("Enter Gender again (male/female/other): ");
            gender = scanner.nextLine();
        }
        return gender;
    }

    public String regexDateOfBirth(String dateOfBirth) {
        while (!regexData.regexDateOfBirth(dateOfBirth)) {
            System.out.print("Enter Date of birth again (dd/mm/yyyy): ");
            dateOfBirth = scanner.nextLine();
        }
        return dateOfBirth;
    }

    public String regexName(String name) {
        while (!regexData.regexName(name)) {
            System.out.print("Enter new Name again: ");
            name = scanner.nextLine();
        }
        return name;
    }

    public String regexIDCode(String idCode) {
        while (!regexData.regexIdCode(idCode)) {
            System.out.print("Enter ID Code again: ");
            idCode = scanner.nextLine();
        }
        return idCode;
    }

    private Employee findById(String idEmp) {
        for (Employee employee : employeeList) {
            if (employee.getIdEmp().equals(idEmp)) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmp() {
        System.out.println("\n1. Update all\n"
                + "2. Update details\n"
                + "3. Return employee menu");
        System.out.print("Enter your choice: ");
        checkChoice(1, 3);
        String id;
        switch (choice) {
            case 1:
                System.out.print("Enter ID of Employee: ");
                id = scanner.nextLine().toUpperCase();
                updateAllInfo(id);
                break;
            case 2:
                System.out.print("Enter ID of Employee: ");
                id = scanner.nextLine().toUpperCase();
                updateDetails(id);
                break;
            case 3:
                furamaController.displayMenuEmployee();
                break;
        }
    }

    private void updateAllInfo(String idEmp) {
        Employee employee = findById(idEmp);
        if (employee != null) {
            System.out.print("Enter ID Code: ");
            String idCode = scanner.nextLine();
            idCode = regexIDCode(idCode);
            employee.setIdCode(idCode);

            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            name = regexName(name);
            employee.setFullName(name);

            System.out.print("Enter Date of birth: ");
            String dateOfBirth = scanner.nextLine();
            dateOfBirth = regexDateOfBirth(dateOfBirth);
            employee.setDateOfBirth(dateOfBirth);

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            gender = regexGender(gender);
            employee.setGender(gender);

            System.out.print("Enter number phone: ");
            String phone = scanner.nextLine();
            phone = regexNumberPhone(phone);
            employee.setPhone(phone);

            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            email = regexEmail(email);
            employee.setEmail(email);

            System.out.print("Enter Degree: ");
            String degree = scanner.nextLine();
            degree = regexDegree(degree);
            employee.setDegree(new Degree(degree));

            System.out.print("Enter position: ");
            String position = scanner.nextLine();
            position = regexPosition(position);
            employee.setPosition(new Position(position));

            System.out.print("Enter salary: ");
            double salary = regexSalary();
            employee.setSalary(salary);

            System.out.println("All information has just been update!");
            saveData();
            if (continues()) {
                updateEmp();
            } else {
                furamaController.displayMenuEmployee();
            }
        } else {
            System.err.println("ID doesn't exist!\n");
            updateEmp();
        }
    }

    private void updateDetails(String id) {
        Employee employee = findById(id);
        if (employee != null) {
            System.out.println("1. Edit ID Code\n"
                    + "2. Edit Name\n"
                    + "3. Edit Date of birth\n"
                    + "4. Edit Gender\n"
                    + "5. Edit Number phone\n"
                    + "6. Edit Email\n"
                    + "7. Edit Degree\n"
                    + "8. Edit Position\n"
                    + "9. Edit Salary\n"
                    + "0. Return menu update");
            System.out.print("Enter your choice: ");
            checkChoice(0, 9);

            switch (choice) {
                case 1:
                    System.out.print("Enter new ID Code: ");
                    String idCode = scanner.nextLine();
                    idCode = regexIDCode(idCode);
                    employee.setIdCode(idCode);
                    System.out.println("ID Code has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 2:
                    System.out.print("Enter new Name: ");
                    String name = scanner.nextLine();
                    name = regexName(name);
                    employee.setFullName(name);
                    System.out.println("Name has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 3:
                    System.out.print("Enter Date of birth: ");
                    String dateOfBirth = scanner.nextLine();
                    dateOfBirth = regexDateOfBirth(dateOfBirth);
                    employee.setDateOfBirth(dateOfBirth);
                    System.out.println("Date of birth has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 4:
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    gender = regexGender(gender);
                    employee.setGender(gender);
                    System.out.println("Gender has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 5:
                    System.out.print("Enter number phone: ");
                    String phone = scanner.nextLine();
                    phone = regexNumberPhone(phone);
                    employee.setPhone(phone);
                    System.out.println("Number phone has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 6:
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    email = regexEmail(email);
                    employee.setEmail(email);
                    System.out.println("Email has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 7:
                    System.out.print("Enter Degree: ");
                    String degree = scanner.nextLine();
                    degree = regexDegree(degree);
                    employee.setDegree(new Degree(degree));
                    System.out.println("Degree has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 8:
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    position = regexPosition(position);
                    employee.setPosition(new Position(position));
                    System.out.println("Position has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 9:
                    System.out.print("Enter salary: ");
                    double salary = regexSalary();
                    employee.setSalary(salary);
                    System.out.println("Salary has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateEmp();
                    }
                case 0:
                    updateEmp();
                default:
                    break;
            }
        } else {
            System.err.println("ID doesn't exist!\n");
            updateEmp();
        }
    }

    private boolean continues() {
        System.out.print("Do you want to continue (Y/N)?: ");
        String choice = scanner.nextLine();

        if (choice.equals("Y") || choice.equals("y")) {
            return true;
        } else if (choice.equals("N") || choice.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid!");
            return false;
        }
    }

    private void checkChoice(int start, int end) {
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                while (choice > end || choice < start) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                break;
            } catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }
    }
}
