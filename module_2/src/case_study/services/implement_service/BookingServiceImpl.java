package case_study.services.implement_service;

import case_study.models.customer_service.Booking;
import case_study.services.interface_service.BookingService;

import java.util.SortedSet;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    static SortedSet<Booking> sortedSetBooking;
    static {
        sortedSetBooking = new TreeSet<>();
        sortedSetBooking.add(new Booking("12", "20", "CTM001", "Villa", "normal"));
        sortedSetBooking.add(new Booking("12", "4", "CTM001", "House", "normal"));
    }
//    public static void addBooking() {
//        CustomerServiceImpl.displayListCustomer();
//        ServiceImpl
//    }

    public static void displayListBooking() {
        System.out.println("\n----------List Booking---------");
        for (Booking booking: sortedSetBooking) {
            System.out.println(booking);
        }
    }
}
