package school.lesson10;

public class Lesson10 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Коробки имеют одинаковый вес? " + appleBox.compare(orangeBox));

        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.moveToAnotherBox(anotherAppleBox);

        System.out.println("Вес коробки с яблоками после пересыпания: " + appleBox.getWeight());
        System.out.println("Вес другой коробки с яблоками: " + anotherAppleBox.getWeight());
    }
}

