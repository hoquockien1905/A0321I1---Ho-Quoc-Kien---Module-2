package bai_12_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    private static List<Product> listProduct;

    static {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "iphone", 10.0));
        listProduct.add(new Product(2, "nokia", 23.1));
        listProduct.add(new Product(3, "oppo", 5.1));
    }

    public static void displayMenu() {
        int choice = 0;

        System.out.println("==========MAIN MENU==========\n"
                + "1. Display list product\n"
                + "2. Add new product\n"
                + "3. Update a product\n"
                + "4. Delete a product\n"
                + "5. Search a product\n"
                + "6. Sort list product\n"
                + "7. Exit.");
        System.out.print("Enter your choice: ");

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 0 && choice < 7) {
                    break;
                }
                while (choice > 7 || choice < 1) {
                    System.err.print("Invalid input! Enter again: ");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                break;
            } catch (Exception e) {
                System.err.print("Invalid input! Enter again: ");
            }
        }

        switch (choice) {
            case 1:
                displayListProduct();
                break;
            case 2:
                addNewProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                searchProduct();
                break;
            case 6:
                sortListProduct();
                break;
            case 7:
                System.out.println("See you again!");
                System.exit(7);
        }
    }

    public static void displayListProduct() {
        System.out.println("========List Product========");
        for (Product infoProduct : listProduct) {
            System.out.println(infoProduct);
        }
        if (listProduct.size() == 0) {
            System.out.println("List product is empty!");
        }

        String asked = asked();

        if (asked.equals("Y") || asked.equals("y")) {
            displayMenu();
        } else if (asked.equals("N") || asked.equals("n")) {
            return;
        }
    }

    public static void addNewProduct() {
        System.out.print("Enter new id: ");
        int newId = scanner.nextInt();
        for (Product product : listProduct) {
            while (product.getIdProduct() == newId) {
                System.err.print("Exist! Enter again: ");
                newId = scanner.nextInt();
            }
        }
        System.out.print("Enter new product name: ");
        String newName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter a price: ");
        double newPrice = scanner.nextDouble();
        listProduct.add(new Product(newId, newName, newPrice));

        System.out.println("New products have been added!");

        if (continueProgram()) {
            addNewProduct();
        } else {
            displayMenu();
        }
    }

    public static Product findById(int id) {
        for (Product product : listProduct) {
            if (product.getIdProduct() == id) {
                return product;
            }
        }
        return null;
    }

    public static void updateProduct() {
        System.out.print("Enter an id: ");
        int id = scanner.nextInt();
        Product product = findById(id);

        if (product == null) {
            System.err.println("Id doesn't exist!");
            updateProduct();
        } else {
            updateDetails(id);
        }

    }

    private static void updateDetails(int id) {
        System.out.println("1. Update name\n"
                         + "2. Update price\n"
                         + "3. Back to Update product");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        Product product = findById(id);
        switch (choice) {
            case 1:
                System.out.print("Enter new Name: ");
                String name = scanner.next();
                scanner.nextLine();
                product.setNameProduct(name);
                System.out.println("Name have been updated!");
                break;
            case 2:
                System.out.print("Enter new Price: ");
                double price = scanner.nextDouble();
                product.setPriceProduct(price);
                System.out.println("Price have been updated!");
                break;
            case 3:
                updateProduct();
                break;
        }

        if (continueProgram()) {
            updateDetails(id);
        } else {
            displayMenu();
        }
    }

    public static void deleteProduct() {
        System.out.print("Enter an id of product: ");
        int id = scanner.nextInt();
        boolean check = false;
        for (Product product: listProduct) {
           if (product.getIdProduct() == id) {
               check = true;
           }
        }
        if (check) {
            listProduct.remove(findById(id));
        } else {
            System.out.println("Id doesn't exist!");
            deleteProduct();
        }

        if (continueProgram()) {
            if (listProduct.size() != 0) {
                deleteProduct();
            } else {
                System.err.print("List product is empty!\n");
                System.out.println();
            }
        } else {
            displayMenu();
        }
    }

    public static void searchProduct() {
        System.out.print("Enter name product: ");
        String nameProduct = scanner.next().toLowerCase();
        scanner.nextLine();
        boolean flag = false;
        for (Product product : listProduct) {
            if (nameProduct.equals(product.getNameProduct())) {
                flag = true;
                System.out.println(product);

            }
        }
        if (!flag) {
            System.out.println("Product doesn't exist");
        }
        if (continueProgram()) {
            searchProduct();
        } else {
            displayMenu();
        }
    }

    public static void sortListProduct() {
        System.out.println("1. Sort by id\n"
                + "2. Sort by name\n"
                + "3. Sort by price");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sortByID();
                System.out.println("Sorted list product!");
                break;
            case 2:
                sortByName();
                System.out.println("Sorted list product!");
                break;
            case 3:
                sortByPrice();
                System.out.println("Sorted list product!");
                break;

        }

        if (continueProgram()) {
            sortListProduct();
        } else {
            displayMenu();
        }
    }

    public static void sortByPrice() {
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(listProduct, priceComparator);
    }

    public static void sortByID() {
        IdComparator idComparator = new IdComparator();
        Collections.sort(listProduct, idComparator);
    }

    public static void sortByName() {
        NameComparator nameComparator = new NameComparator();
        Collections.sort(listProduct, nameComparator);
    }

    public static boolean continueProgram() {

        String asked = asked();

        if (asked.equals("Y") || asked.equals("y")) {
            return true;
        } else if (asked.equals("N") || asked.equals("n")) {
            return false;
        } else {
            System.err.println("Invalid input!");
            return false;
        }
    }

    public static String asked() {
        System.out.print("Do you want to continue? (Y/N): ");
        String asked = scanner.next();
        scanner.nextLine();
        return asked;
    }
}
