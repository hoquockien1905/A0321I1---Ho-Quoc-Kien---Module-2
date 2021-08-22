package bai_17_binary_file_va_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.io.Serializable;

public class Product implements Serializable {
    private static int auId = 1;
    private String idProduct = "PR00";
    private String productName;
    private String manufacturer;
    private double price;
    private String description;

    public Product() {
    }

    public Product(String productName, String manufacturer, double price, String description) {
        this.idProduct = idProduct + auId++;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{ " +
                "ID Product: " + idProduct +
                ", Product Name: " + productName +
                ", Manufacturer: " + manufacturer +
                ", Price: " + price +
                ", Description: " + description +
                " }";
    }
}
