package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.person.customer.Customer;
import case_study.models.person.customer.CustomerType;
import case_study.models.person.employee.Employee;
import case_study.services.interface_service.CustomerService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static Scanner scanner = new Scanner(System.in);
    public static List<Customer> customerList = new LinkedList<>();
    static FuramaController furamaController = new FuramaController();
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private static int choice;

    public void saveData() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\customer.csv");

            for (Customer customer: customerList) {
                String line = customer.getFileLine();
                byte[] bytes = line.getBytes("UTF-8");
                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
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
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\customer.csv");
            fileReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Customer customer = new Customer();
                customer.parse(line);
                customerList.add(customer);
            }
            Customer.setAutoId(customerList.size() + 1);
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

    public void displayListCustomer() {
        System.out.println("\n========= Customer List ========");
        customerList = new LinkedList<>();
        readFile();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        furamaController.displayMenuCustomer();
    }

    public void addCustomer() {
        readFile();
        System.out.print("Enter ID Code: ");
        String idCode = scanner.nextLine();
        idCode = employeeService.regexIDCode(idCode);
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        name = employeeService.regexName(name);
        System.out.print("Enter Date of birth: ");
        String dateOfBirth = scanner.nextLine();
        dateOfBirth = employeeService.regexDateOfBirth(dateOfBirth);
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        gender = employeeService.regexGender(gender);
        System.out.print("Enter Number phone: ");
        String phone = scanner.nextLine();
        phone = employeeService.regexNumberPhone(phone);
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        email = employeeService.regexEmail(email);
        System.out.print("Enter Customer type: ");
        String customerType = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        customerList.add(new Customer(idCode, name, dateOfBirth, gender, phone, email, new CustomerType(customerType), address));
        System.out.println("A new customer has just been added!");
        saveData();

        if (continues()) {
            addCustomer();
        } else {
            furamaController.displayMenuCustomer();
        }
    }

    private Customer findById(String id) {
        for (Customer customer : customerList) {
            if (customer.getIdCustomer().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomer() {
        readFile();
        System.out.println("\n1. Update all\n"
                + "2. Update details\n"
                + "3. Return customer menu");
        System.out.print("Enter your choice: ");
        checkChoice(1, 3);
        String id;
        switch (choice) {
            case 1:
                System.out.print("Enter ID of Customer: ");
                id = scanner.nextLine().toUpperCase();
                updateAllInfo(id);
                break;
            case 2:
                System.out.print("Enter ID of Customer: ");
                id = scanner.nextLine().toUpperCase();
                updateDetails(id);
                break;
            case 3:
                furamaController.displayMenuCustomer();
                break;
        }
    }

    private void updateAllInfo(String idCustomer) {
        Customer customer = findById(idCustomer);
        if (customer != null) {
            System.out.print("Enter ID Code: ");
            String idCode = scanner.nextLine();
            customer.setIdCode(idCode);

            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            customer.setFullName(name);

            System.out.print("Enter Date of birth: ");
            String dateOfBirth = scanner.nextLine();
            customer.setDateOfBirth(dateOfBirth);

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            customer.setGender(gender);

            System.out.print("Enter number phone: ");
            String phone = scanner.nextLine();
            customer.setPhone(phone);

            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            customer.setEmail(email);

            System.out.print("Enter Customer type: ");
            String customerType = scanner.nextLine();
            customer.setCustomerType(new CustomerType(customerType));

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            customer.setAddress(address);

            System.out.println("All information has just been update!");
            saveData();

            if (continues()) {
                updateCustomer();
            } else {
                furamaController.displayMenuCustomer();
            }
        } else {
            System.err.println("ID doesn't exist!\n");
            updateCustomer();
        }
    }

    private void updateDetails(String id) {
        Customer customer = findById(id);
        if (customer != null) {
            System.out.println("1. Edit ID Code\n"
                    + "2. Edit Name\n"
                    + "3. Edit Date of birth\n"
                    + "4. Edit Gender\n"
                    + "5. Edit Number phone\n"
                    + "6. Edit Email\n"
                    + "7. Edit Customer type\n"
                    + "8. Edit Address\n"
                    + "0. Return menu update");
            System.out.print("Enter your choice: ");
            checkChoice(0, 8);

            switch (choice) {
                case 1:
                    System.out.print("Enter new ID Code: ");
                    String idCode = scanner.nextLine();
                    customer.setIdCode(idCode);
                    System.out.println("ID Code has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 2:
                    System.out.print("Enter new Name: ");
                    String name = scanner.nextLine();
                    customer.setFullName(name);
                    System.out.println("Name has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 3:
                    System.out.print("Enter Date of birth: ");
                    String dateOfBirth = scanner.nextLine();
                    customer.setDateOfBirth(dateOfBirth);
                    System.out.println("Date of birth has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 4:
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    customer.setGender(gender);
                    System.out.println("Gender has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 5:
                    System.out.print("Enter number phone: ");
                    String phone = scanner.nextLine();
                    customer.setPhone(phone);
                    System.out.println("Number phone has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 6:
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    customer.setEmail(email);
                    System.out.println("Email has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 7:
                    System.out.print("Enter Customer type: ");
                    String customerType = scanner.nextLine();
                    customer.setCustomerType(new CustomerType(customerType));
                    System.out.println("Customer type has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 8:
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    customer.setAddress(address);
                    System.out.println("Address has just been updated!");
                    saveData();
                    if (continues()) {
                        updateDetails(id);
                    } else {
                        updateCustomer();
                    }
                case 0:
                    updateCustomer();
                default:
                    break;
            }
        } else {
            System.err.println("ID doesn't exist!\n");
            updateCustomer();
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
