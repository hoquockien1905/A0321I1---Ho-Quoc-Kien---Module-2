package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.person.employee.Degree;
import case_study.models.person.employee.Employee;
import case_study.models.person.employee.Position;
import case_study.services.interface_service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList;
    static FuramaController furamaController = new FuramaController();
    private static int choice;

    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("206314831", "Hồ Quốc Kiên", "19/05/1999", "Nam", "0399733998", "hquockien@gmail.com", new Degree("University"), new Position("Accountant"), 211000.0));
        employeeList.add(new Employee("258952346", "Nguyễn Chí Kiên", "16/04/2000", "Nam", "0399732621", "hkien@gmail.com", new Degree("College"), new Position("Security officer"), 11100.0));
        employeeList.add(new Employee("268461458", "Võ Minh Kiên", "05/06/2001", "Nam", "0368246792", "hqkien@gmail.com", new Degree("University"), new Position("Direction"), 5111000.0));
        employeeList.add(new Employee("261331287", "Trần Trung Kiên", "27/07/2007", "Nam", "0393985745", "hoquockien@gmail.com", new Degree("University"), new Position("Manager"), 1111000.0));
    }

    public static void displayListEmp() {
        System.out.println("========= Employee List ========");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        furamaController.displayMenuEmployee();
    }

    public static void addNewEmp() {
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

        employeeList.add(new Employee(idCode, name, dateOfBirth, gender, phone, email, new Degree(degree), new Position(position), salary));
        System.out.println("A new employee has just been added!");

        if (continues()) {
            addNewEmp();
        } else {
            furamaController.displayMenuEmployee();
        }
    }

    private static Employee findById(String idEmp) {
        for (Employee employee : employeeList) {
            if (employee.getIdEmp().equals(idEmp)) {
                return employee;
            }
        }
        return null;
    }

    public static void updateEmp() {
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

    private static void updateAllInfo(String idEmp) {
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

    private static void updateDetails(String id) {
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

    private static boolean continues() {
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

    private static void checkChoice(int start, int end) {
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
