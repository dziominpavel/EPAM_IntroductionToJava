package Task1.Task1_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count;

        System.out.println("Введите 7-х значное число");
        count = initializing();
        for (int element : reverseArray(intNumbersToArray(count))) {
            System.out.print(element);
        }

    }

    //метод инициализирует 7-х значную переменную типа int
    private static int initializing() {
        int count;

        while (true) {
            try {
                count = new Scanner(System.in).nextInt();
                if (count >= 1_000_000 && count <= 9_999_999) {
                    return count;
                } else if (count <= -1_000_000 && count >= -9_999_999) {
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
        int[] array = new int[7];
        int temp = 1;
        for (int i = 6; i >= 0; i--) {
            if (i != 6) {
                array[i] = (count % (temp * 10) - array[i + 1]) / temp;
            } else {
                array[i] = (count % (temp * 10)) / temp;
            }
            temp *= 10;
        }
        return array;
    }

    // метод проверяет знак заданного числа и отправляет это число со знаком плюс в метод intPlusNumbersToArray(int)
    private static int[] intNumbersToArray(int count) {
        if (count > 0) {
            return intPlusNumbersToArray(count);
        } else {
            int[] array = intPlusNumbersToArray(-count);
            array[0] = -1 * array[0];
            return array;
        }
    }

    private static int[] reverseArray(int[] array) {
        int[] newArray = new int[7];
        int j = 6;
        for (int i = 0; i < 7; i++) {
            newArray[j--] = array[i];
        }
        return newArray;
    }
}
