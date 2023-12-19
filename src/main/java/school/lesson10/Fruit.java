package school.lesson10;

import java.util.ArrayList;
import java.util.List;

// Базовый класс для фруктов
    abstract class Fruit {
        abstract float getWeight();
    }

    // Класс для яблок
    class Apple extends Fruit {
        @Override
        float getWeight() {
            return 1.0f;
        }
    }

    // Класс для апельсинов
    class Orange extends Fruit {
        @Override
        float getWeight() {
            return 1.5f;
        }
    }

    // Класс коробки с обобщениями
    class Box<T extends Fruit> {
        private List<T> fruits = new ArrayList<>();

        // Добавление фрукта в коробку
        public void addFruit(T fruit) {
            fruits.add(fruit);
        }

        // Расчет веса коробки
        public float getWeight() {
            float weight = 0.0f;
            for (T fruit : fruits) {
                weight += fruit.getWeight();
            }
            return weight;
        }

        // Сравнение коробок
        public boolean compare(Box<?> otherBox) {
            return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
        }

        // Пересыпание фруктов в другую коробку
        public void moveToAnotherBox(Box<T> otherBox) {
            otherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        }
    }

