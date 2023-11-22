package school.lesson5;

abstract class Animal {
    private static int count;
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;

    abstract void run(int length);

    abstract void swim(int length);

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

