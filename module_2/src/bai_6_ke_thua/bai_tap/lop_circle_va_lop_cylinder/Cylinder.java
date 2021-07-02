package bai_6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return (this.height * (Math.pow(getRadius(), 2) * Math.PI));
    }

    @Override
    public String toString() {
        return "Cylinder {" +
                " height = " + getHeight() +
                '}' + " \nis subclass of " + super.toString();
    }
}
