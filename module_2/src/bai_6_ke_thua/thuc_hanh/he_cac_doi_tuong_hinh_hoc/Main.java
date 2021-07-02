package bai_6_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();

        System.out.println(shape);
        shape = new Shape("red", false);
        System.out.println(shape);

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2.5);
        System.out.printf("Area of Circle: %.2f", circle.getArea());
        System.out.printf("\nPerimeter of Circle: %.2f\n", circle.getPerimeter());
        System.out.println(circle);

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(5.3, 2.6);
        System.out.printf("Area of Rectangle: %.2f", rectangle.getArea());
        System.out.printf("\nPerimeter of Rectangle: %.2f\n", rectangle.getPerimeter());
        rectangle.setColor("blue");
        rectangle.setFilled(false);
        System.out.println(rectangle);
    }
}
