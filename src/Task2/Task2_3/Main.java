package Task2.Task2_3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int MIN_COUNT = 10;
        final int MAX_COUNT = 1000;

        int number = generateCount(MIN_COUNT, MAX_COUNT);
//        int number = 28;

        System.out.println("Сгенерированное число: " + number);

        if (isPerfect(number)) {
            System.out.println("Число " + number + " совершенное");
        } else {
            System.out.println("Число " + number + " НЕ совершенное");
        }
    }


    /**
     * method generating random int from the specified range
     *
     * @param minCount bottom line of range
     * @param maxCount upper line of range
     * @return random number
     */
    private static int generateCount(int minCount, int maxCount) {
        if (minCount > 0 && maxCount >= minCount) {
            return new Random().nextInt(maxCount - minCount) + minCount;
        } else {
            System.out.println("Введен не корректный диапазон для генерации числа");
            return 0;
        }
    }

    /**
     * method finds sum of all divisors of specified number
     */
    private static int findSumDivisors(int number) {
        int sum = 0;

        if (number > 1) {
            for (int divider = 1; divider < number; divider++) {
                if (number % divider == 0) {
                    sum += divider;
                }
            }
        }
        return sum;

    }

    /**
     * method define that the number is perfect number
     * number equals sum of all divisors
     * (ex: 28=1+2+4+7+14)
     */
    private static boolean isPerfect(int number) {
        return number == findSumDivisors(number);
    }

}
