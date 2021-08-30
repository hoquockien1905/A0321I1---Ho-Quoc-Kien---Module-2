package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.person.employee.Degree;
import case_study.models.person.employee.Employee;
import case_study.models.person.employee.Position;
import case_study.services.interface_service.EmployeeService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    static FuramaController furamaController = new FuramaController();
    private static int choice;

    public void saveData() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\employee.csv");

            for (Employee employee: employeeList) {
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

    public void readFile(){
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
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Number phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Degree: ");
        String degree = scanner.nextLine();
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        employeeList.add(new Employee(idCode, name, dateOfBirth, gender, phone, email, new Degree(degree), new Position(position), salary));
        System.out.println("A new employee has just been added!");
        saveData();

        if (continues()) {
            addNewEmp();
        } else {
            furamaController.displayMenuEmployee();
        }
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
            employee.setIdCode(idCode);

            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            employee.setFullName(name);

            System.out.print("Enter Date of birth: ");
            String dateOfBirth = scanner.nextLine();
            employee.setDateOfBirth(dateOfBirth);

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            employee.setGender(gender);

            System.out.print("Enter number phone: ");
            String phone = scanner.nextLine();
            employee.setPhone(phone);

            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            employee.setEmail(email);

            System.out.print("Enter Degree: ");
            String degree = scanner.nextLine();
            employee.setDegree(new Degree(degree));

            System.out.print("Enter position: ");
            String position = scanner.nextLine();
            employee.setPosition(new Position(position));

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
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
                    double salary = scanner.nextDouble();
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
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }
    }
}
