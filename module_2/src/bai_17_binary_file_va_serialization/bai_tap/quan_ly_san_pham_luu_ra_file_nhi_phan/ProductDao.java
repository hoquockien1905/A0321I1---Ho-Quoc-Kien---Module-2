package bai_17_binary_file_va_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String PRODUCT_FILE_NAME = "src/bai_17_binary_file_va_serialization/bai_tap/quan_ly_san_pham_luu_ra_file_nhi_phan/product";


    public static void write(List<Product> products) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(PRODUCT_FILE_NAME);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }

            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }

    public static List<Product> read() throws IOException {
        List<Product> products = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(new File(PRODUCT_FILE_NAME));
            objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }

            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }

        return products;
    }
}
