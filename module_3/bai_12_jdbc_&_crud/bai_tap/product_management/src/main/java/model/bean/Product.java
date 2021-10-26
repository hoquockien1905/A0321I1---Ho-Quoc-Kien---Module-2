package model.bean;

public class Product {
    private int id;
    private static int autoId = 1;
    private String name;
    private double price;

    public Product() {
        this.id = autoId++;
    }

    public Product(String name, double price) {
        this.id = autoId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
