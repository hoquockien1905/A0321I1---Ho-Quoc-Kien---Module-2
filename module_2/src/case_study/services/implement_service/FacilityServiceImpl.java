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
        facilityService.put(new House("House", 115.5, 100000.5, 5, "Ordinary", "Ordinary", 15), 4);
        facilityService.put(new Villa("Villa", 20.5, 22222.0, 4, "VIP", "VIP", 115.5, 20), 4);
        facilityService.put(new Room("Room", 25.5, 1000.5, 2, "Ordinary", "Water"), 4);
    }

    public void displayListFacility() {
        System.out.println("\n=========List Services=========");
        for (Map.Entry service : facilityService.entrySet()) {
            System.out.println(service);
        }
    }

    public void addService() {
        System.out.println("\n--------Menu Add New Service--------\n" +
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

    private void inputSameInfo(Facility service) {
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

    public void addNewVilla() {
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
        if (continues()) {
            addNewVilla();
        } else {
            furamaController.displayMenuFacility();
        }
    }

    public void addNewHouse() {
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

        if (continues()) {
            addNewHouse();
        } else {
            furamaController.displayMenuFacility();
        }
    }

    public void addNewRoom() {
        Room room = new Room();
        inputSameInfo(room);

        System.out.print("\nFree Service To Accompany: ");
        String freeServiceToAccompany = scanner.nextLine();
        room.setFreeServiceToAccompany(freeServiceToAccompany);

        System.out.println("A new House has just been added!");

        facilityService.put(room, 0);

        if (continues()) {
            addNewRoom();
        } else {
            furamaController.displayMenuFacility();
        }
    }

    public void displayListFacilityMaintenance() {
        System.out.println("\n========List in need of maintenance========");
        boolean check = resetTimesUses();
        if (check) {
            System.out.println("All under maintenance!");
        } else {
            System.out.println("All maintenance has been completed!");
        }
    }

    private boolean resetTimesUses() {
        int index = 1;
        boolean check = false;
        for (Map.Entry service : facilityService.entrySet()) {
            int value = (int) service.getValue();
            if (value >= 5) {
                System.out.println(index + ": " + service);
                check = true;
                service.setValue(0);
            }
            index++;
        }
        return check;
    }

    private void checkChoice(int start, int end) {
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

    private boolean continues() {
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
}
