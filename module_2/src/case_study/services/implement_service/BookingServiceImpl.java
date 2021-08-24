package case_study.services.implement_service;

import bai_4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan.Fan;
import case_study.controllers.FuramaController;
import case_study.models.customer_service.Booking;
import case_study.models.facility.Facility;
import case_study.models.person.customer.Customer;
import case_study.services.interface_service.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static SortedSet<Booking> bookings;
    static Customer customer = new Customer();
    static {
        bookings = new TreeSet<>();
//        sortedSetBooking.add(new Booking("12", "20", customer.getIdCustomer(), "Villa", "normal"));
//        sortedSetBooking.add(new Booking("12", "4", customer.getIdCustomer(), "House", "normal"));
    }
//    public static void addBooking() {
//        CustomerServiceImpl.displayListCustomer();
//        ServiceImpl
//    }

    public static void addNewBooking() {
        System.out.println("\n========List ID Customer========");
        List<Customer> customers = CustomerServiceImpl.customerList;
        int index = 0;
        for (Customer customer: customers) {
            System.out.println("No." + index + ": " + customer.getIdCustomer());
            index++;
        }

        System.out.print("Enter a number of list: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String idCustomer = null;
        for (Customer customer: customers) {
            if (choice == customers.indexOf(customer)) {
                idCustomer = customer.getIdCustomer();
            }
        }

        System.out.println("\n========List Services========");
        LinkedHashMap<Facility, Integer> facilities = FacilityServiceImpl.facilityService;
        Facility facility = null;
        int indexOfFacilities = 0;
        for (Map.Entry fac: facilities.entrySet()) {
            facility = (Facility) fac.getKey();
            System.out.println("No." + indexOfFacilities + ": " + facility.getServiceName());
            indexOfFacilities++;
        }

        System.out.print("Enter a number of facility list: ");
        Scanner scanner2 = new Scanner(System.in);
        int choice2 = scanner2.nextInt();
        int index1 = 0;
        String serviceName = null;
        LinkedHashMap<Facility, Integer> facilities1 = FacilityServiceImpl.facilityService;
        for (Map.Entry fac: facilities1.entrySet()) {
            facility = (Facility) fac.getKey();
            if (choice2 == index1) {
                serviceName = facility.getServiceName();
                FacilityServiceImpl.facilityService.put((Facility) fac.getKey(), (int) fac.getValue() + 1);
                break;
            }
            index1++;
        }
        bookings.add(new Booking("12", "4", idCustomer, serviceName, "normal"));

        BookingServiceImpl.displayListBooking();
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }

    public static void displayListBooking() {
        System.out.println("\n----------List Booking---------");
        for (Booking booking: bookings) {
            System.out.println(booking);
        }
    }
}
