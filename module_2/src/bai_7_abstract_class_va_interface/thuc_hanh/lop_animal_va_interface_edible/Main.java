package bai_7_abstract_class_va_interface.thuc_hanh.lop_animal_va_interface_edible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal o : animals) {
            System.out.println(o.makeSound());
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit o : fruits) {
            System.out.println(o.howToEat());
        }

        Edible chicken = new Chicken();
        System.out.println(chicken.howToEat());
    }
}
