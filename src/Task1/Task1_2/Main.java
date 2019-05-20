package Task1.Task1_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double kilo;

        System.out.println("Введите массу динозавра в килограммах");
        kilo = initializing();
        System.out.println("Масса динозавра: ");
        System.out.printf("%.2f", kiloToMilligram(kilo));
        System.out.println(" милиграмм");
        System.out.println(kiloToGram(kilo) + " грамм");
        System.out.println(kiloToTon(kilo) + " тонн");
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
                    System.out.println("Ошибка ввода, введите корректное значение");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    private static double kiloToMilligram(double kilo) {
        return kilo * 1_000_000;
    }

    private static double kiloToGram(double kilo) {
        return kilo * 1_000;
    }

    private static double kiloToTon(double kilo) {
        return kilo / 1000;
    }


}
