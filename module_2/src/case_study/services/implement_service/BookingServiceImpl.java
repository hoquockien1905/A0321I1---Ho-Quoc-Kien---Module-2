package case_study.services.implement_service;

import case_study.models.customer_service.Booking;
import case_study.models.facility.Facility;
import case_study.models.person.customer.Customer;
import case_study.services.interface_service.BookingService;
import case_study.utilities.BookingComparator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Set<Booking> bookings = new TreeSet<>(new BookingComparator());
    static Scanner scanner = new Scanner(System.in);
    static LinkedHashMap<Facility, Integer> facilities = FacilityServiceImpl.facilityService;
    static List<Customer> customers = CustomerServiceImpl.customerList;

    public Set<Booking> sendBooking() {
        return bookings;
    }

    public void saveDate() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\booking.csv");

            for (Booking booking : bookings) {
                String line = booking.getLineFile();
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

    public void readFile() {
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\booking.csv");
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);
            bookings = new TreeSet<>(new BookingComparator());
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Booking booking = new Booking();
                booking.parse(line);
                bookings.add(booking);
            }
            Booking.setAuId(Booking.getAuId() + 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
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

    public void addNewBooking() {
        System.out.print("Enter a start day: ");
        String startDay = scanner.nextLine();

        System.out.print("Enter an end day: ");
        String endDay = scanner.nextLine();

        System.out.print("Enter a service type: ");
        String serviceType = scanner.nextLine();

        bookings.add(new Booking(startDay, endDay, chooseIdCustomer(), chooseServiceName(), serviceType));
        saveDate();

        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        bookingServiceImpl.displayListBooking();
    }

    private String chooseIdCustomer() {
        showListIdCustomer();
        System.out.print("Enter a number of list: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        boolean check = true;
        String idCustomer = null;
        while (check) {
            for (Customer customer : customers) {
                if (choice == customers.indexOf(customer)) {
                    idCustomer = customer.getIdCustomer();
                    check = false;
                }
            }
            if (check) {
                System.out.print("Enter again, please: ");
                choice = scanner.nextInt();
            }
        }
        return idCustomer;
    }

    private String chooseServiceName() {
        showListServiceName();
        Facility facility;
        System.out.print("Enter a number of facility list: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String serviceName = null;
        boolean check = true;
        while (check) {
            int index = 0;
            for (Map.Entry fac : facilities.entrySet()) {
                facility = (Facility) fac.getKey();
                if (choice == index) {
                    serviceName = facility.getServiceName();
                    FacilityServiceImpl.facilityService.put((Facility) fac.getKey(), (int) fac.getValue() + 1);
                    check = false;
                    break;
                }
                index++;
            }
            if (check) {
                System.out.print("Enter again, please: ");
                choice = scanner.nextInt();
            }
        }
        return serviceName;
    }

    private void showListIdCustomer() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.readFile();
        System.out.println("\n========List ID Customer========");
        int index = 0;
        for (Customer customer : customers) {
            System.out.println("No." + index + ": " + customer);
            index++;
        }
    }

    private void showListServiceName() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.readFileVilla();
        facilityService.readFileVilla();
        facilityService.readFileRoom();
        System.out.println("\n========List Services========");
        Facility facility = null;
        int indexOfFacilities = 0;
        for (Map.Entry fac : facilities.entrySet()) {
            facility = (Facility) fac.getKey();
            System.out.println("No." + indexOfFacilities + ": " + facility);
            indexOfFacilities++;
        }
    }

    public void displayListBooking() {
        System.out.println("\n----------List Booking---------");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
