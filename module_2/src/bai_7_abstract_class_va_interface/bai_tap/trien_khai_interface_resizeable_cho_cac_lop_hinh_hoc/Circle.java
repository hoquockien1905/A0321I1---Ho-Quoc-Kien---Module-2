package bai_7_abstract_class_va_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

import bai_6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Circle extends Shape implements Resizeable{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (Math.pow(radius, 2) * Math.PI);
    }

    public double getPerimeter() {
        return (2 * radius * Math.PI);
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + getRadius() + ", \nwhich is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() + (getRadius() * (percent / 100)));
    }
}
