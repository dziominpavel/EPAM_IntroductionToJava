package Task2.Task2_4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int MIN_COUNT = 1;
        final int MAX_COUNT = 100000;

        printFriendlyNumbers(MIN_COUNT, MAX_COUNT);
    }


    /**
     * method finds sum of all divisors of specified number
     */
    private static int findSumDivisors(int number) {
        int sum = 0;

        if (number > 1) {
            for (int divisor = 1; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    sum += divisor;
                }
            }
        }
        return sum;

    }

    /**
     * method define that the number has a different friendly number
     */
    private static boolean isFriendly(int number) {
        return number == findSumDivisors(findSumDivisors(number));
    }

    /**
     * Method prints all friendly numbers in the specified range
     */
    private static void printFriendlyNumbers(int minCount, int maxCount) {
        System.out.println("В дипазоне от " + minCount + " до " + maxCount);
        System.out.println("Найдены следующие пары дружественных чисел:");
        for (int i = minCount; i < maxCount; i++) {
            if (isFriendly(i) && i != findSumDivisors(i)) {
                System.out.println(i + " " + findSumDivisors(i));
            }
        }
    }

}
