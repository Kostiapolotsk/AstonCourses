package school.lesson5;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    // Метод для уменьшения количества еды в тарелке
    public boolean decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        }
        return false; // Не хватило еды, кот остается голодным
    }

    // Метод для добавления еды в тарелку
    public void addFood(int amount) {
        food += amount;
    }


    // Геттер для количества еды в тарелке
    public int getFood() {
        return food;
    }
}

