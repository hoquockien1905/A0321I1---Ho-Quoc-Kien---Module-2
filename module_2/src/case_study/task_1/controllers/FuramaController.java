package case_study.task_1.controllers;

import java.util.Scanner;

public class FuramaController {
    private int choice;

    public void displayMainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--------Main Menu--------");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 7 && choice > 0) {
                    break;
                }
                while (choice > 6 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

        switch (choice) {
            case 1:
                displayMenuEmployee();
                break;
            case 2:
                displayMenuCustomer();
                break;
            case 3:
                displayMenuFacility();
                break;
            case 4:
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
        Scanner sc = new Scanner(System.in);

        System.out.println("\n------Employee Management------");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Return main menu");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice > 4 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuCustomer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n------Customer Management------");
        System.out.println("1. Display list customer");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice > 4 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuFacility() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------Facility Management------");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance");
        System.out.println("4. Return main menu");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice > 4 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuBooking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------Booking Management------");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new contract");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contract");
        System.out.println("6. Return main menu");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice > 6 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                displayMainMenu();
                break;
        }
    }

    public void displayMenuPromotion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------Promotion Management------");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                while (choice > 3 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(sc.nextLine());
                }
                break;
            }
            catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

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
}
