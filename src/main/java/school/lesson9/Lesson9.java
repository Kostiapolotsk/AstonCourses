package school.lesson9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lesson9 {


    public static void main(String[] args) {
        //Задание №1.
        System.out.println("Задание №1.");
        Random random = new Random();

        // Генерируем поток случайных чисел
        int size = 10; // Количество чисел в потоке
        IntStream randomNumbers = random
                .ints(size, 1, 100); // Диапазон чисел от 1 до 100

        // Подсчет количества четных чисел
        long countEven = randomNumbers
                .filter(n -> n % 2 == 0) // Фильтрация четных чисел
                .count(); // Подсчет количества чисел

        System.out.println("Количество четных чисел: " + countEven);

        //Задание №2.
        System.out.println("\nЗадание №2. Задаем коллекция, состоящая из строк:" +
                " «Highload», «High», «Load», «Highload».");
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        // №2.1.
        System.out.println("\nЗадание №2.1.");
        String filterdHigh = String.valueOf(collection.stream().filter("High"::equals).count());
        System.out.println("Сколько раз обьект \"High\" встречается в колекции: " + filterdHigh + " раз.");
        // №2.2.
        System.out.println("\nЗадание №2.2.");
        String a = collection.stream().findFirst().orElse("0");
        System.out.println("Какой элемент в колеции находится на первом месте: " + a);
        // №2.3.
        System.out.println("\nЗадание №2.3.");
        String lastElement = collection.stream()
                .reduce((first, second) -> second)
                .orElse("0");
        System.out.println("Последний элемент или 0: " + lastElement);

        //Задание 3
        System.out.println("\nЗадание №3.");
        List<String> collection1 = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        String[] sortedArray = collection1.stream()
                // Отсортировать используя числовую часть строки после 'f'
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                // Собрать результаты в массив
                .toArray(String[]::new);
        // Вывести отсортированный массив
        System.out.println(Arrays.toString(sortedArray));

        //Задание №4
        System.out.println("\nЗадание №4.");
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 22, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        // 4.1. Средний возраст студентов мужского пола
        double averageAgeOfMen = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);

        System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMen);

        // 4.2. Студенты, которым грозит получение повестки
        List<Student> studentsForConscription = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());

        System.out.println("Студенты, которым грозит получение повестки: " + studentsForConscription);

        //Задание №5.
        System.out.println("\nЗадание №5.");
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        while (true) {
            System.out.println("Введите логин (или оставьте строку пустой для завершения):");
            String login = scanner.nextLine();

            // Проверка на пустую строку для завершения ввода
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        // Вывод логинов, начинающихся на 'f'
        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());

        System.out.println("Логины, начинающиеся на 'f': " + filteredLogins);

    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" + "name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
        }
        // equals и hashCode опущены для краткости
    }
}

