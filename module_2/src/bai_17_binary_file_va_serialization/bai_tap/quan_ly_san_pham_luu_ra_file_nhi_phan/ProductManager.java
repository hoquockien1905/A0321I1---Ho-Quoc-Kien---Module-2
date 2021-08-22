package bai_17_binary_file_va_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static List<Product> products;
    static private int choice;
    static Scanner scanner = new Scanner(System.in);

    static {
        products = new ArrayList<>();
        products.add(new Product("Romano", "US", 2000, "good"));
        products.add(new Product("Glasses", "Japan", 15000, "good quality"));
        products.add(new Product("Mobile phone", "Vietnam", 1000000, "diamond"));
    }

    private static void checkChoice(int start, int end){
        while (true){
            try {
                choice = Integer.parseInt(scanner.nextLine());
                while (choice < start || choice > end) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                break;
            }catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("\n=========Main Menu=========\n" +
                "1. Add new product\n" +
                "2. Display list product\n" +
                "3. Search a information product\n" +
                "4. Exit.");
        System.out.print("Enter your choice: ");
        checkChoice(1, 4);
        switch (choice) {
            case 1:
                addNewProduct();
                mainMenu();
            case 2:
                displayListProduct();
                mainMenu();
            case 3:
                productToLookFor();
            case 4:
                System.out.println("See you!");
                System.exit(4);
        }
    }

    private static void productToLookFor() {
        System.out.print("Enter ID of product: ");
        String id = scanner.nextLine().toUpperCase();
        if (searchProduct(id) != null) {
            System.out.println("\nProducts to look for below:");
            System.out.println(searchProduct(id));
            mainMenu();
        } else {
            System.out.println("Not found!");
            mainMenu();
        }
    }

    public static void addNewProduct() {
        System.out.print("Enter new product: ");
        String name = scanner.nextLine();
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.skip("\\R");

        System.out.println("A new product just has been added!");
        products.add(new Product(name, manufacturer, price, description));
    }

    public static void displayListProduct() {
        System.out.println("\n========List product========");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Product searchProduct(String id) {
        for (Product product : products) {
            if (product.getIdProduct().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
