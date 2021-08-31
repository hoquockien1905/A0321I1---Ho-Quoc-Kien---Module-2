package case_study.controllers;

import case_study.services.implement_service.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class FuramaController {
    private int choice;
    static Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {

        System.out.println("\n--------Main Menu--------");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl();
        FacilityServiceImpl facilityServiceImpl = new FacilityServiceImpl();
        checkChoice(1, 6);
        switch (choice) {
            case 1:
                employeeServiceImpl.readFile();
                displayMenuEmployee();
                break;
            case 2:
                displayMenuCustomer();
                break;
            case 3:
                FacilityServiceImpl.facilityService = new LinkedHashMap<>();
                facilityServiceImpl.readFileVilla();
                facilityServiceImpl.readFileHouse();
                facilityServiceImpl.readFileRoom();
                displayMenuFacility();
                break;
            case 4:
                bookingService.readFile();
                displayMenuBooking();
                break;
            case 5:
                displayMenuPromotion();
                break;
            case 6:
                System.exit(6);
        }
    }

    public void displayMenuEmployee() {

        System.out.println("\n------Employee Management------");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Return main menu");
        System.out.print("Enter your choice: ");

        checkChoice(1, 4);
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        switch (choice) {
            case 1:
                employeeServiceImpl.displayListEmp();
                break;
            case 2:
                employeeServiceImpl.addNewEmp();
                break;
            case 3:
                employeeServiceImpl.updateEmp();
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuCustomer() {

        System.out.println("\n------Customer Management------");
        System.out.println("1. Display list customer");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu");
        System.out.print("Enter your choice: ");

        checkChoice(1, 4);
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        switch (choice) {
            case 1:
                customerServiceImpl.displayListCustomer();
                displayMenuCustomer();
                break;
            case 2:
                customerServiceImpl.addCustomer();
                break;
            case 3:
                customerServiceImpl.updateCustomer();
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuFacility() {
        System.out.println("\n------Facility Management------");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance");
        System.out.println("4. Return main menu");
        System.out.print("Enter your choice: ");

        checkChoice(1, 4);
        FacilityServiceImpl facilityServiceImpl = new FacilityServiceImpl();
        switch (choice) {
            case 1:
                facilityServiceImpl.displayListFacility();
                displayMenuFacility();
                break;
            case 2:
                facilityServiceImpl.addService();
                displayMenuFacility();
                break;
            case 3:
                facilityServiceImpl.displayListFacilityMaintenance();
                displayMenuFacility();
                break;
            case 4:
                displayMainMenu();
        }
    }

    public void displayMenuBooking() {
        System.out.println("\n------Booking Management------");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new contract");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contract");
        System.out.println("6. Return main menu");
        System.out.print("Enter your choice: ");

        checkChoice(1, 6);
        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        ContractServiceImpl contractServiceImpl = new ContractServiceImpl();
        switch (choice) {
            case 1:
                bookingServiceImpl.addNewBooking();
                displayMenuBooking();
                break;
            case 2:
                bookingServiceImpl.displayListBooking();
                displayMenuBooking();
                break;
            case 3:
                contractServiceImpl.createNewContract();
                displayMenuBooking();
                break;
            case 4:
                contractServiceImpl.readFile();
                contractServiceImpl.displayListContracts();
                displayMenuBooking();
                break;
            case 5:
                contractServiceImpl.updateContract();
                displayMenuBooking();
                break;
            case 6:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuPromotion() {
        System.out.println("\n------Promotion Management------");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.print("Enter your choice: ");

        checkChoice(1, 3);

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                displayMainMenu();
                break;
        }
    }

    private void checkChoice(int start, int end) {
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice > end || choice < start) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            } catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }
    }
}
