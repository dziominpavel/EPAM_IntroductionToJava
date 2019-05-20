package Task1.Task1_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a;
        double b;
        double c;

        System.out.println("Введите 3 числа:");

        a = initializing();
        b = initializing();
        c = initializing();

        if (compare(a, b)) {
            if (compare(b, c)) {
                System.out.println("Все три числа равны!");
            } else {
                System.out.println("Первое число равно второму, но второе НЕ равно третьему!");
            }
        } else {
            if (compare(b, c)) {
                System.out.println("Первое число НЕ равно второму, но второе равно третьему!");
            } else {
                if (compare(a, c)) {
                    System.out.println("Первое число НЕ равно второму, но первое равно третьему!");
                } else{
                    System.out.println("Все три числа отличны друг от друга!");
                }
            }
        }
    }

    //метод инициализирует переменную типа double
    private static double initializing() {
        double d;

        while (true) {
            try {
                d = new Scanner(System.in).nextDouble();
                return d;
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    //метод проверяет на равенство двух переменных типа Double
    private static boolean compare(double first, double second) {
        return first == second;
    }

}
