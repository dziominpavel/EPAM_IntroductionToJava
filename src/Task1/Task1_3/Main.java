package Task1.Task1_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double r1;
        double r2;

        System.out.println("Введите радиусы кругов");

        while (true) {
            r1 = initializing();
            r2 = initializing();
            if (r1 > r2) {
                break;
            } else {
                System.out.println("Первый радиус должен быть больше второго, повторите ввод");
            }
        }

        System.out.print("Площадь кольца равна: ");
        System.out.println(calcCircleSquare(r1) - calcCircleSquare(r2));

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

    //метод возвращает площадь круга с заданным радиусом
    private static double calcCircleSquare(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

}
