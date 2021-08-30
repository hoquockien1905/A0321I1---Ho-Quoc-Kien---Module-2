package case_study.services.implement_service;

import case_study.controllers.FuramaController;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.services.interface_service.FacilityService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    public static LinkedHashMap<Facility, Integer> facilityService = new LinkedHashMap<>();
    ;
    static FuramaController furamaController = new FuramaController();
    static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public void saveDataVilla() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\villa.csv");

            for (Map.Entry entry : facilityService.entrySet()) {
                if (entry.getKey() instanceof Villa) {
                    Villa villa = (Villa) entry.getKey();
                    String line = villa.getLineFile();
                    byte[] bytes = line.getBytes("UTF-8");
                    fileOutputStream.write(bytes);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void readFileVilla() {
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\villa.csv");
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Villa villa = new Villa();
                villa.parse(line);
                facilityService.put(villa, 0);
            }
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

    public void saveDataHouse() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\house.csv");

            for (Map.Entry entry : facilityService.entrySet()) {
                if (entry.getKey() instanceof  House) {
                    House house = (House) entry.getKey();
                    String line = house.getLineFile();
                    byte[] bytes = line.getBytes("UTF-8");
                    fileOutputStream.write(bytes);
                }
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

    public void readFileHouse() {
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\house.csv");
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                House house = new House();
                house.parse(line);
                facilityService.put(house, 0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataRoom() {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\room.csv");

            for (Map.Entry entry : facilityService.entrySet()) {
                if (entry.getKey() instanceof  Room) {
                    Room room = (Room) entry.getKey();
                    String line = room.getLineFile();
                    byte[] bytes = line.getBytes("UTF-8");
                    fileOutputStream.write(bytes);
                }
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

    public void readFileRoom() {
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\case_study\\data\\room.csv");
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Room room = new Room();
                room.parse(line);
                facilityService.put(room, 0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        scanner.nextLine();

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
        scanner.nextLine();

        System.out.println("A new Villa has just been added!");
        facilityService.put(villa, 0);
        saveDataVilla();

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
        saveDataHouse();
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
        saveDataRoom();
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
