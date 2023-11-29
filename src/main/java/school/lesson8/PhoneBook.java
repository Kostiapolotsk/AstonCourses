package school.lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи в справочник
    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для поиска всех телефонных номеров по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    // Пример использования
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+12345678");
        phoneBook.add("Петров", "+87654321");
        phoneBook.add("Иванов", "+18273645");

        System.out.println("Номера Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера Петрова: " + phoneBook.get("Петров"));
    }
}

