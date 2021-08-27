package case_study.services.implement_service;

import case_study.models.customer_service.Booking;
import case_study.models.customer_service.Contract;
import case_study.models.person.customer.Customer;
import case_study.services.interface_service.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static Queue<Contract> contracts;
    static List<Customer> customers = CustomerServiceImpl.customerList;
    static Scanner scanner = new Scanner(System.in);

    static {
        contracts = new LinkedList<>();
    }

    @Override
    public void displayListContracts() {
        System.out.println("\n========List Contracts========");
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }

        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            String idCustomerBooking = booking.getIdCustomerBooking();
            String customer = "";
            for (Customer cus : customers) {
                if (idCustomerBooking.equals(cus.getIdCustomer())) {
                    customer = cus.toString();
                }
            }

            System.out.println("Contract is being created for Booking's information: " + booking.toString());
            System.out.println("Contract is being created for Customer's information: " + customer);

            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();

            System.out.print("Enter total amount: ");
            double totalAmount = scanner.nextDouble();

            String idBooking = booking.getIdBooking();
            String idCustomer = booking.getIdCustomerBooking();

            contracts.add(new Contract(idBooking, depositAmount, totalAmount, idCustomer));
            System.out.println("\nThe contract has just been added successfully!");
        }
    }

    private Contract findByIdContract(String id) {
        for (Contract contract : contracts) {
            if (id.equals(contract.getIdContract())) {
                return contract;
            }
        }
        return null;
    }

    public void updateContract() {
//        System.out.print("Enter ID: ");
//        String id = scanner.nextLine();
//        Contract contract = findByIdContract(id);
//        if (contract != null) {
//            System.out.print("Enter ID Booking: ");
//            String idBooking = scanner.nextLine();
//            contract.setIdBooking(idBooking);
//
////                System.out.println();
//        }
    }
}
