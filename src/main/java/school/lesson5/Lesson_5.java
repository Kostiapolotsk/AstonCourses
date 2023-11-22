package school.lesson5;

public class Lesson_5 {

    public static void main(String[] args) {
        // Задание №1
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Мурзик", 5);
        cat[1] = new Cat("Барсик", 10);
        cat[2] = new Cat("Васька", 15);
        cat[1].run(200);
        cat[1].swim(1);

        Dog dog = new Dog("Бобик");
        dog.run(500);
        dog.swim(10);

        Plate plate = new Plate(25);

        for (Cat cats : cat) {
            cats.eat(plate);
            System.out.println(cats.getName() + " сытость: " + cats.isFullness());
        }

        // Добавим еды в тарелку
        plate.addFood(15);

        System.out.println("Еды в тарелке после добавления: " + plate.getFood());
        System.out.println("Всего котов создано: " + Cat.getCount());
        System.out.println("Всего собак создано: " + Dog.getCount());
        System.out.println("Всего животных создано: " + Animal.getCount());


        // Задание №2
        Info circle = new Circle(5, "Red", "Black");
        Info rectangle = new Rectangle(4, 6, "Blue", "Green");
        Info triangle = new Triangle(3, 4, 5, "Yellow", "Pink");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
