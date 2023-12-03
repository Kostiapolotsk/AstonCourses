package school.lesson5;

class Cat extends Animal {
    private String name;
    private int appetite; // Количество еды, необходимое для насыщения
    private boolean fullness; // Сытость кота
    private static int count; // Количество котов
    private final int MAX_RUN_LENGTH = 200; // Саксимальная длинна препятствия

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println("Котик пробежал " + length + "м.");
        else System.out.println("Котик столько пробежать не сможет.");
    }

    @Override
    void swim(int length) {
        System.out.println("Котики не плавают.");
    }

    public static int getCount() {
        return count;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false; // Все коты изначально голодны
        count++;
    }

    // Метод для попытки кота поесть
    public void eat(Plate plate) {
        if (!fullness && plate.decreaseFood(appetite)) {
            fullness = true; // Кот наелся
        }
    }

    // Геттер для имени кота
    public String getName() {
        return name;
    }

    // Геттер для сытости кота
    public boolean isFullness() {
        return fullness;
    }
}