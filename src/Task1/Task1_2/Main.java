package Task1.Task1_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double kilo;

        System.out.println("Введите массу динозавра в килограммах");

        kilo = initializing();

        System.out.println("Масса динозавра: ");
        System.out.println(kiloToMiligramm(kilo) + " миллиграмм");
        System.out.println(kiloToGramm(kilo) + " грамм");
        System.out.println(kiloToTonn(kilo) + " тонн");

    }

    //метод инициализирует переменную больше нуля типа double
    private static double initializing() {
        double d;

        while (true) {
            try {
                d = new Scanner(System.in).nextDouble();
                if (d > 0) {
                    return d;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    private static double kiloToMiligramm(double kilo) {
        return kilo * 1_000_000;
    }

    private static double kiloToGramm(double kilo) {
        return kilo * 1_000;
    }

    private static double kiloToTonn(double kilo) {
        return kilo / 1000;
    }


}
