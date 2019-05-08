package Task1.Task1_8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double firstX, firstY, secondX, secondY, thirdX, thirdY;
        double firstSide, secondSide, thirdSide;

        System.out.println("Введите 2 координаты первой точки");
        firstX = initializing();
        firstY = initializing();

        System.out.println("Введите 2 координаты второй точки");
        secondX = initializing();
        secondY = initializing();

        System.out.println("Введите 2 координаты третьей точки");
        thirdX = initializing();
        thirdY = initializing();

        firstSide = calcSideLength(firstX, firstY, secondX, secondY);
        secondSide = calcSideLength(secondX, secondY, thirdX, thirdY);
        thirdSide = calcSideLength(firstX, firstY, thirdX, thirdY);

        if (checkTriangle(firstSide, secondSide, thirdSide)) {
            if (checkRectangularTriangle(firstSide, secondSide, thirdSide)) {
                System.out.println("Заданные вершины являются вершинами прямоугольного треугольника");
            } else {
                System.out.println("Заданные вершины являются вершинами простого треугольника");
            }
        } else {
            System.out.println("заданные вершины НЕ являются вершинами треугольника");
        }
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

    // метод вычисляет длинну отрезка между двумя точками с заданными координатами
    private static double calcSideLength(double firstX, double firstY,
                                         double secondX, double secondY) {

        return Math.sqrt(Math.abs(Math.pow((firstX - secondX), 2) - Math.pow((firstY - secondY), 2)));
    }

    // метод проверяет возможно ли построить треугольник из трех заданных отрезков
    private static boolean checkTriangle(double firstSide, double secondSide, double thirdSide) {

        return firstSide < secondSide + thirdSide
                && secondSide < firstSide + thirdSide
                && thirdSide < firstSide + secondSide;


    }

    // метод проверяет является треугольник прямоугольным
    private static boolean checkRectangularTriangle(double firstSide, double secondSide, double thirdSide) {

        if (firstSide > secondSide && firstSide > thirdSide) {
            return Math.pow(firstSide, 2) == Math.pow(secondSide, 2) + Math.pow(thirdSide, 2);
        } else if (secondSide > firstSide && secondSide > thirdSide) {
            return Math.pow(secondSide, 2) == Math.pow(firstSide, 2) + Math.pow(thirdSide, 2);
        } else if (thirdSide > firstSide && thirdSide > secondSide) {
            return Math.pow(thirdSide, 2) == Math.pow(firstSide, 2) + Math.pow(secondSide, 2);
        } else return false;
    }
}




