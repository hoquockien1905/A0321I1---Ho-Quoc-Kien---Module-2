package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.services.interface_service.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    static LinkedHashMap<Facility, Integer> facilityService;
    static FuramaController furamaController = new FuramaController();
    static Scanner scanner = new Scanner(System.in);
    private static int choice;

    static {
        facilityService = new LinkedHashMap<>();
        facilityService.put(new House("House", 115.5, 100000.5, 5, "Ordinary", "Ordinary", 15), 0);
        facilityService.put(new Villa("Villa", 20.5, 22222.0, 4, "VIP", "VIP", 115.5, 20), 0);
        facilityService.put(new Room("Room", 25.5, 1000.5, 2, "Ordinary", "Water"), 0);
    }

    public static void displayListFacility() {
        System.out.println("\n=========List Services=========");
        for (Map.Entry o : facilityService.entrySet()) {
            System.out.println(o);
        }

        furamaController.displayMenuFacility();
    }

    public static void addService() {
        System.out.println("--------Menu Add New Service--------\n" +
                "1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu");
        System.out.print("Enter your choice: ");
        checkChoice(1, 4);
        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                furamaController.displayMenuFacility();
        }
    }

    private static void inputSameInfo(Facility service) {
        System.out.print("Service Name: ");
        String serviceName = scanner.nextLine();
        service.setServiceName(serviceName);

        System.out.print("Use Area: ");
        double useArea = scanner.nextDouble();
        service.setUseArea(useArea);

        System.out.print("Rental Costs: ");
        double rentalCost = scanner.nextDouble();
        service.setRentalCosts(rentalCost);

        System.out.print("Maximum Number Of People: ");
        int maximumPeople = scanner.nextInt();
        service.setMaximumNumberOfPeople(maximumPeople);

        System.out.print("Rental Type: ");
        String rentalType = scanner.nextLine();
        service.setRentalType(rentalType);
    }

    private static void addNewVilla() {
        Villa villa = new Villa();
        inputSameInfo(villa);

        System.out.print("\nRoom Standard: ");
        String roomStandard = scanner.nextLine();
        villa.setRoomStandard(roomStandard);

        System.out.print("Area Of Pool: ");
        double areaOfPool = scanner.nextDouble();
        villa.setAreaOfPool(areaOfPool);

        System.out.print("Number Of Floors: ");
        int numberOfFloors = scanner.nextInt();
        villa.setNumberOfFloors(numberOfFloors);

        System.out.println("A new Villa has just been added!");

        facilityService.put(villa, 0);

    }

    private static void addNewHouse() {
        House house = new House();
        inputSameInfo(house);

        System.out.print("\nRoom Standard: ");
        String roomStandard = scanner.nextLine();
        house.setRoomStandard(roomStandard);

        System.out.print("Number Of Floors: ");
        int numberOfFloors = scanner.nextInt();
        house.setNumberOfFloors(numberOfFloors);

        System.out.println("A new House has just been added!");

        facilityService.put(house, 0);
    }

    private static void addNewRoom() {
        Room room = new Room();
        inputSameInfo(room);

        System.out.print("\nFree Service To Accompany: ");
        String freeServiceToAccompany = scanner.nextLine();
        room.setFreeServiceToAccompany(freeServiceToAccompany);

        System.out.println("A new House has just been added!");

        facilityService.put(room, 0);
    }

    public static void displayListFacilityMaintenance() {

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
