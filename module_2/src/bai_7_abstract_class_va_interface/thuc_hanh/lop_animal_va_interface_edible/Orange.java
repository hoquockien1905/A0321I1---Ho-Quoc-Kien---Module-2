package bai_7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible;

public class Orange extends Fruit{
    public Orange() {
    }

    @Override
    public String howToEat() {
        return "Orange could be juiced!";
    }
}
