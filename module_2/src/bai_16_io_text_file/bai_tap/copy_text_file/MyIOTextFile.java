package bai_16_io_text_file.bai_tap.copy_text_file;

import java.io.*;

public class MyIOTextFile {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\bai_16_io_text_file\\bai_tap\\copy_text_file\\text.txt");
            fileOutputStream = new FileOutputStream("D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\bai_16_io_text_file\\bai_tap\\copy_text_file\\text_copy.txt");
            int check;
            while ((check = fileInputStream.read()) != -1) {
                System.out.print((char)check);
                fileOutputStream.write(check);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

