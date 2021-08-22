package bai_16_io_text_file.bai_tap.optional_doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    static Country country = new Country("1.0.0.0","1.0.0.255","16777216","16777471","AU","Australia");
    static Country country1 = new Country("1.0.1.0","1.0.3.255","16777472","16778239","CN","China");
    static Country country2 = new Country("1.0.4.0","1.0.7.255","16778240","16779263","AU","Australia");
    static Country country3 = new Country("1.0.8.0","1.0.15.255","16779264","16781311","CN","China");
    static Country country4 = new Country("1.0.16.0","1.0.31.255","16781312","16785407","JP","Japan");
    static Country country5 = new Country("1.0.32.0","1.0.63.255","16785408","16793599","CN","China");
    static Country country6 = new Country("1.0.64.0","1.0.127.255","16793600","16809983","JP","Japan");
    static Country country7 = new Country("1.0.128.0","1.0.255.255","16809984","16842751","TH","Thailand");

    private static void writeCsv(String path){
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path, true));
            bufferedWriter.write(country.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country1.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country2.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country3.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country4.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country5.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country6.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(country7.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String pathDemo = "D:\\Codegym\\A0321I1---Ho-Quoc-Kien---Module-2\\module_2\\src\\bai_16_io_text_file\\bai_tap\\optional_doc_file_csv\\demo.csv";
        String line = "";
        final String DELIMITER = ",";
        writeCsv(pathDemo);
        List<Country> countryList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathDemo));
            while ((line = bufferedReader.readLine()) != null) {
                String[] countryArr = line.split(DELIMITER);
                country = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country1 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country2 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country3 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country4 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country5 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country6 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                country7 = new Country(countryArr[0], countryArr[1], countryArr[2], countryArr[3], countryArr[4], countryArr[5]);
                countryList.add(country);
                countryList.add(country1);
                countryList.add(country2);
                countryList.add(country3);
                countryList.add(country4);
                countryList.add(country5);
                countryList.add(country6);
                countryList.add(country7);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
