package school.lesson3;

public class Lesson_3 {
    //Задание №1
    public static boolean check(int a, int b) {
        int s = a + b;
        return s >= 10 && s <= 20;
    }

    //Задание №2
    public static void isPlusOrMinus(int a) {
        System.out.println((a >= 0) ? "Положительное" : "Отрицательное");
    }

    //Задание №3
    public static boolean pozitivOrNegativ(int a) {
        return a < 0;
    }

    //Задание №4
    public static void stringInteger(String s, int x) {
        System.out.println(s.repeat(x));
    }

    //Задание №5
    public static boolean leapYear(int x) {
        return x % 4 == 0 && x % 100 != 0 || x % 400 == 0;
    }

    public static void main(String[] args) {
        System.out.println("Задание №1:");
        System.out.println(check(2, 1));
        System.out.println("Задание №2:");
        stringInteger("Привет ", 5);
        System.out.println("Задание №3:");
        isPlusOrMinus(2);
        System.out.println("Задание №4:");
        System.out.println(pozitivOrNegativ(2));
        System.out.println("Задание №5:");
        System.out.println(leapYear(2005));

        //Задание №6
        System.out.println("Задание №6:");
        int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                numbers[i] = 0;
            } else numbers[i] = 1;
            System.out.print(numbers[i] + " ");
        }

        System.out.println(" ");

        //Задание №7
        System.out.println("Задание №7:");
        int[] num = new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
            System.out.print(num[i]);
        }

        System.out.println(" ");

        //Задание №8
        System.out.println("Задание №8:");
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {
                mas[i] = mas[i] * 2;
            }
            System.out.print(mas[i]);
        }
        System.out.println(" ");

        //Задание №9
        System.out.println("Задание №9:");
        int[][] cube = new int[4][4];
        for (int i = 0; i < cube.length; i++) {
            cube[i][i] = 1;
        }
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube.length; j++)
                System.out.printf("%3s", cube[i][j]);
            System.out.println();
        }
        System.out.println("Задание №10:");
        arr(10,8);
    }

    //Задание №10
    public static int[] arr(int len, int initialValue) {
        int arr2[] = new int[len];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = initialValue;
            System.out.print(arr2[i]);
        }
        return arr2;
    }
}
