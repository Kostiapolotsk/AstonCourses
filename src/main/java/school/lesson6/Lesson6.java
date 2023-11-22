package school.lesson6;

import java.io.*;
import java.util.*;


public class Lesson6 {
    public static void main(String[] args) {
        AppData appData = new AppData();

        // Инициализируем данные
        appData.setHeader(new String[]{"Value1", "Value2", "Value3"});
        appData.setData(new int[][]{
                {100, 200, 123},
                {300, 400, 500},
        });

        // Сохраняем данные в файл
        try {
            appData.save("data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загружаем данные из файла
        AppData newData = new AppData();
        try {
            newData.load("data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Выводим загруженные данные в консоль (для проверки)
        System.out.println(Arrays.toString(newData.getHeader()));
        for (int[] row : newData.getData()) {
            System.out.println(Arrays.toString(row));
        }
    }
}
