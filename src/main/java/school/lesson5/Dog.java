package school.lesson5;

class Dog extends Animal {
    private String name;
    private static int count;
    private final int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println(name + " пробежал " + length + "м.");
        else System.out.println(name + " столько пробежать не сможет.");
    }

    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH)) System.out.println(name + " проплыл " + length + "м.");
        else System.out.println(name + " столько проплыть не сможет.");
    }

    public static int getCount() {
        return count;
    }

    public Dog(String name) {
        this.name = name;
        count++;
    }
}
