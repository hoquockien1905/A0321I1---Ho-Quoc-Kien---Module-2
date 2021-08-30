package case_study.services.implement_service;

import case_study.models.customer_service.Booking;
import case_study.models.customer_service.Contract;
import case_study.models.person.customer.Customer;
import case_study.services.interface_service.ContractService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ContractServiceImpl implements ContractService {
    static Queue<Contract> contracts = new LinkedList<>();
    static List<Customer> customers = CustomerServiceImpl.customerList;
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayListContracts() {
        System.out.println("\n========List Contracts========");
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    public void saveDate() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\contract.csv");
            for (Contract contract : contracts) {
                String line = contract.getLineFile();
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
            saveDate();
        }
    }

    public void readFile() {
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\contract.csv");
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);
            contracts = new LinkedList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Contract contract = new Contract();
                contract.parse(line);
                contracts.add(contract);
            }
            Contract.setAutoId(Contract.getAutoId() + 1);
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
