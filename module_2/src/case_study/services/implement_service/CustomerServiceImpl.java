package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.person.customer.Customer;
import case_study.models.person.customer.CustomerType;
import case_study.services.interface_service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList;
    static FuramaController furamaController = new FuramaController();
    private static int choice;

    static {
        customerList = new LinkedList<>();
        customerList.add(new Customer("206314832", "Trần Văn An", "14/05/1989", "Nam", "0935685468", "tran@gmail.com", new CustomerType("VIP"), "DN"));
        customerList.add(new Customer("268535435", "Nguyễn Thị Đào", "02/08/1959", "Nữ", "0635284925", "dao@gmail.com", new CustomerType("Ordinary"), "QN"));
        customerList.add(new Customer("235684431", "Lê Văn Chánh", "09/12/1985", "Nam", "0395864824", "chanh@gmail.com", new CustomerType("Ordinary"), "HN"));
        customerList.add(new Customer("248834352", "Phạm Thu Trang", "16/02/1977", "Nữ", "0369856846", "bao@gmail.com", new CustomerType("VIP"), "HCM"));
    }

    public static void displayListCustomer() {
        System.out.println("========= Customer List ========");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        furamaController.displayMenuCustomer();
    }

    public static void addCustomer() {
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
        System.out.print("Enter Customer type: ");
        String customerType = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        customerList.add(new Customer(idCode, name, dateOfBirth, gender, phone, email, new CustomerType(customerType), address));
        System.out.println("A new customer has just been added!");

        if (continues()) {
            addCustomer();
        } else {
            furamaController.displayMenuCustomer();
        }
    }

    private static Customer findById(String id) {
        for (Customer customer : customerList) {
            if (customer.getIdCustomer().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public static void updateCustomer() {
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

    private static void updateAllInfo(String idCustomer) {
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

    private static void updateDetails(String id) {
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
            } catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }
    }
}
