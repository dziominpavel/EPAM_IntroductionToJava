package classwork;

import java.util.Random;

public class Main {
    private static final int COUNT_ELEMENTS = 2; //константа задает размер массива
    private static final double MIN_VALUE = -10;  //константа задает минимальное значение для массива
    private static final double MAX_VALUE = 10;  //константа задает максимальное значение для массива
    private static final double ACTUAL_VALUE = -5;  //константа задает искомое значение

    public static void main(String[] args) {
        double[] array = new double[COUNT_ELEMENTS];

        initializeArray(array, MIN_VALUE, MAX_VALUE);

        System.out.println("Сгенерирован массив:");
        printArray(array);
        System.out.print("\nВ массиве " + findCountBigerElements(array, ACTUAL_VALUE) + " элементов ");
        System.out.println("больше, чем " + ACTUAL_VALUE);

        int indexMaxAbsElement = findIndexMaxAbsValue(array);

        System.out.println("Максимальный по модулю элемент находится на " + (indexMaxAbsElement + 1) + " позиции");
        System.out.println("Произведение чисел после указанного равно " + findMulElements(array, indexMaxAbsElement));

    }

    /**
     * метод инициализирует и возвращает массив случайными числами
     */
    private static void initializeArray(double[] array, double minValue, double maxValue) {
        int arrayLength = array.length;

        if (arrayLength == 0) {
            throw new IllegalArgumentException("Массив не задан");
        }

        for (int i = 0; i < arrayLength; i++) {
            array[i] = new Random().nextDouble() * ((maxValue - minValue)) + minValue;
        }

    }

    /**
     * метод выводит на экран массив
     */
    private static void printArray(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не задан");
        }

        for (double element : array) {
            System.out.println(element);
        }

    }

    /**
     * метод считает количество элементов в массиве больших заданного
     */
    private static int findCountBigerElements(double[] array, double actualValue) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не задан");
        }

        if (actualValue < MIN_VALUE || actualValue > MAX_VALUE) {
            return 0;
        }

        int count = 0;                    // счетчик

        for (double element : array) {
            if (element > actualValue) {
                count++;
            }
        }

        return count;
    }

    /**
     * метод возвращает индекс максимального по модулю элемента
     */
    private static int findIndexMaxAbsValue(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не задан");
        }

        int index = 0;                                 // индекс максимального элемента
        double maxValue = array[0];                    // значение по модулю максимального элемента

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) > maxValue) {
                index = i;
                maxValue = Math.abs(array[i]);
            }
        }

        return index;
    }

    /**
     * метод считает произведение чисел массива после указанного индекса
     */
    private static double findMulElements(double[] array, int index) {
        int arrayLength = array.length;

        if (index >= arrayLength) {
            throw new IllegalArgumentException("Индекс превышает длинну массива");
        } else if (arrayLength == 0) {
            throw new IllegalArgumentException("Массив не задан");
        }
        if (index == arrayLength - 1) {
            throw new IllegalArgumentException("заданный элемент стоит на самом краю");
        }

        double mul = 1;                                        // переменная для произведения чисел элемента

        for (int i = index + 1; i < arrayLength; i++) {
            mul *= array[i];
        }
        return mul;
    }
}
