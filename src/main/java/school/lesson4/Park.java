package school.lesson4;

public class Park {
    // Внутренний класс для представления аттракционов в парке
    public class Attraction {
        private String name; // Название аттракциона
        private String workingHours; // Время работы аттракциона
        private double price; // Стоимость аттракциона

        // Конструктор для создания нового аттракциона
        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        // Метод для вывода информации об аттракционе
        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Работает с: " + workingHours);
            System.out.println("Цена билета: " + price + " руб.");
        }
    }
}
