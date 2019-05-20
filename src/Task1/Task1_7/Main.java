package Task1.Task1_7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a;
        double b;

        System.out.println("Введите 2 числа");
        a = initializing();
        b = initializing();

        if (a != b) {
            a = a - b;
            b = a + b;
            a = b - a;
        }
        System.out.println("a= " + a);
        System.out.println("b= " + b);
    }

    //метод инициализирует переменную типа double
    private static double initializing() {
        double count;
        while (true) {
            try {
                count = new Scanner(System.in).nextDouble();
                return count;
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }


}
