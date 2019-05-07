package Task1.Task1_4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count;

        System.out.println("Введите 4-х значное натуральное число");
        count = initializing();

        if (checkSequence(count)){
            System.out.println("Цифры заданного числа образуют возрастающую последовательность");
        } else {
            System.out.println("Цифры заданного числа НЕ образуют возрастающую последовательность");
        }
    }

    //метод инициализирует 4-х значную переменную типа int
    private static int initializing() {
        int count;

        while (true) {
            try {
                count = new Scanner(System.in).nextInt();
                if (count >= 1000 && count <= 9999) {
                    return count;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    //метод проверяет, что цифры четырёхзначного числа N образуют возрастающую последовательность
    // (к примеру, число 1357 удовлетворяет условию, т.к. его цифры соответствуют следующему
    // неравенству: 1 < 3 < 5 < 7, т.е. идут в порядке возрастания).
    private static boolean checkSequence(int count) {
        int first;
        int second;
        int third;
        int fours;

        fours = count % 10;
        third = (count % 100 - fours) / 10;
        second = (count % 1000 - third) / 100;
        first = (count % 10000 - second) / 1000;

        return first < second && second < third && third < fours;
    }
}
