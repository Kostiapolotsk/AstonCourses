package school.lesson4;

public class Lesson_4 {
    public static void main(String[] args) {
        Person person1 = new Person("Иванов Иван Иванович", "Разработчик", "ivanov@example.com", "+71234567890", 50000, 30);
        person1.info();

        //Создание массива из 5 сотрудников и вывод с помощью цикла информации только о сотрудниках старше 40 лет
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivan Ivanov", "Engineer", "ivanov@mailbox.com", "892312312", 3000, 30);
        persArray[1] = new Person("Ivan Petrov", "Engineer", "petrov@mailbox.com", "892312313", 3100, 31);
        persArray[2] = new Person("Ivan Sidorov", "Engineer", "sidorov@mailbox.com", "892312314", 3200, 32);
        persArray[3] = new Person("Ivan Puchkov", "Engineer", "puchkov@mailbox.com", "892312315", 3300, 33);
        persArray[4] = new Person("Ivan Muchkov", "Engineer", "muchkov@mailbox.com", "892312313", 3400, 41);
        for (Person person : persArray)
            if (person.age > 40) person.info();

        // Создание объекта парка
        Park park = new Park();
        Park.Attraction rollerCoaster = park.new Attraction("Американские горки", "10:00 - 22:00", 150.0);
        rollerCoaster.displayInfo();
    }
}
