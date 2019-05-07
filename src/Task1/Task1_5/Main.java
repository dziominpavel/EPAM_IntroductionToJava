package Task1.Task1_5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count;

        System.out.println("Введите 6-х значное число");
        count = initializing();

        System.out.println("Среднее арифметическое равно: " + average(intNumbersToArray(count)));
        System.out.println("Среднее геометрическое равно: " + averageGeometric(intNumbersToArray(count)));
    }

    //метод инициализирует 6-х значную переменную типа int
    private static int initializing() {
        int count;

        while (true) {
            try {
                count = new Scanner(System.in).nextInt();
                if (count >= 100000 && count <= 999999) {
                    return count;
                } else if (count <= -100000 && count >= -999999) {
                    return count;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    //метод возвращает массив чисел цифр от заданного 6-тизначного положительного числа.
    // например входное число 356438, возвращает array{3,5,6,4,3,8}
    private static int[] intPlusNumbersToArray(int count) {
        int[] array = new int[6];
        int temp = 1;
        for (int i = 5; i >= 0; i--) {
            if (i != 5) {
                array[i] = (count % (temp * 10) - array[i + 1]) / temp;
            } else {
                array[i] = (count % (temp * 10)) / temp;
            }
            temp *= 10;
        }
        return array;
    }

    // метод проверяет знак заданного числа и отправляет его со знаком плюс в метод intPlusNumbersToArray(int)
    private static int[] intNumbersToArray(int count) {
        if (count > 0) {
            return intPlusNumbersToArray(count);
        } else {
            int [] array = intPlusNumbersToArray(-count);
            array[0] = -1*array[0];
            return array;
        }
    }

    //метод считает среднее арифметическое чисел массива
    private static double average(int[] array) {
        int sum = 0;

        for (int i : array) {
            sum = sum + i;
        }

        return (double) sum / array.length;
    }

    //метод считает среднее геометрическое чисел массива
    private static double averageGeometric(int[] array) {
        int mul = 1;

        for (int i : array) {
            mul = mul * i;
        }

        return Math.pow(mul, 1.0 / array.length);
    }

}
