package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.customer_service.Booking;
import case_study.models.facility.Facility;
import case_study.models.person.customer.Customer;
import case_study.services.interface_service.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static SortedSet<Booking> bookings;
    static Scanner scanner = new Scanner(System.in);

    static {
        bookings = new TreeSet<>();
    }

    public static void addNewBooking() {
        System.out.print("Enter a start day: ");
        String startDay = scanner.nextLine();

        System.out.print("Enter an end day: ");
        String endDay = scanner.nextLine();

        System.out.print("Enter a service type: ");
        String serviceType = scanner.nextLine();

        bookings.add(new Booking(startDay, endDay, addIdCustomer(), addServiceName(), serviceType));

        BookingServiceImpl.displayListBooking();
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }

    private static String addIdCustomer() {
        showListIdCustomer();

        System.out.print("Enter a number of list: ");
        List<Customer> customers = CustomerServiceImpl.customerList;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String idCustomer = null;
        for (Customer customer: customers) {
            if (choice == customers.indexOf(customer)) {
                idCustomer = customer.getIdCustomer();
            }
        }
        return idCustomer;
    }

    private static void showListIdCustomer() {
        System.out.println("\n========List ID Customer========");
        List<Customer> customers = CustomerServiceImpl.customerList;
        int index = 0;
        for (Customer customer: customers) {
            System.out.println("No." + index + ": " + customer.getIdCustomer());
            index++;
        }
    }

    private static void showListService() {
        System.out.println("\n========List Services========");
        LinkedHashMap<Facility, Integer> facilities = FacilityServiceImpl.facilityService;
        Facility facility = null;
        int indexOfFacilities = 0;
        for (Map.Entry fac: facilities.entrySet()) {
            facility = (Facility) fac.getKey();
            System.out.println("No." + indexOfFacilities + ": " + facility.getServiceName());
            indexOfFacilities++;
        }
    }

    private static String addServiceName() {
        showListService();

        Facility facility;
        System.out.print("Enter a number of facility list: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        int index = 0;
        String serviceName = null;
        LinkedHashMap<Facility, Integer> facilities = FacilityServiceImpl.facilityService;
        for (Map.Entry fac: facilities.entrySet()) {
            facility = (Facility) fac.getKey();
            if (choice == index) {
                serviceName = facility.getServiceName();
                FacilityServiceImpl.facilityService.put((Facility) fac.getKey(), (int) fac.getValue() + 1);
                break;
            }
            index++;
        }
        return serviceName;
    }

    public static void displayListBooking() {
        System.out.println("\n----------List Booking---------");
        for (Booking booking: bookings) {
            System.out.println(booking);
        }
    }
}
