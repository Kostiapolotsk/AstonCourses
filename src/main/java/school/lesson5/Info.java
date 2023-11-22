package school.lesson5;

public interface Info {
    double getArea();

    double getPerimeter();

    String getFillColor();

    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter() +
                ", Площадь: " + getArea() +
                ", Цвет фона: " + getFillColor() +
                ", Цвет границ: " + getBorderColor());
    }
}
