package Task2.Task2_2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int MIN_COUNT = 1;
        final int MAX_COUNT = 1000;

        int numberOne = generateCount(MIN_COUNT, MAX_COUNT);
        int numberTwo = generateCount(MIN_COUNT, MAX_COUNT);
        System.out.println("Сгенерированное число: " + numberOne);
        System.out.println("Максимальная цифра данного числа: " + findMaxNumeral(numberOne));
        System.out.println("Число - палиндром? : " + isPalindrome(numberOne));
        System.out.println("Число - простое? : " + isSimpleNumber(numberOne));
        System.out.print("Простые делители: ");
        printAllSimpleDividers(numberOne);
        System.out.println("НОД(" + numberOne + "," + numberTwo + ") = " + findNod(numberOne, numberTwo));
        System.out.println("НОК(" + numberOne + "," + numberTwo + ") = " + findNok(numberOne, numberTwo));
        System.out.println("Количество различных цифр в сгенерированном числе: " + calcCountTermsFromSumPowersOfTwo(calcNumeralToSumPowersOfTwo(numberOne)));
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

    // метод находит наибольшую цифру натурального числа
    private static int findMaxNumeral(int number) {
        if (number != 0) {
            int max = 0;
            while (number != 0) {
                if (max < number % 10) {
                    max = number % 10;
                }
                number /= 10;
            }
            return max;
        } else {
            return 0;
        }
    }

    // метод проверяет является ли число палиндромом
    private static boolean isPalindrome(int number) {

        if (number != 0) {
            int reverseNumber = 0;
            int copyNumber = number;
            while (number != 0) {
                reverseNumber *= 10;
                reverseNumber += number % 10;
                number /= 10;

            }
            return reverseNumber == copyNumber;
        } else {
            return false;
        }
    }

    // метод проверяет является ли число простым
    private static boolean isSimpleNumber(int number) {
        if (number == 0) {
            return false;
        }

        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // метод выводит в консоль все простые делители заданного числа
    private static void printAllSimpleDividers(int number) {

        if (number > 1) {
            for (int divider = 1; divider <= number; divider++) {

                if (number % divider == 0) {
                    for (int j = 2; j < divider; j++) {
                        if (divider % j == 0) {
                            break;
                        }
                    }
                    if (isSimpleNumber(divider)) {
                        System.out.print(divider + "; ");
                    }
                }
            }
        }
        System.out.println();
    }

    // метод находит наибольшее число
    private static int findMax(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber ? firstNumber : secondNumber;
    }

    /**
     * Find minimal number between two of them
     *
     * @param firstNumber  first number
     * @param secondNumber second number
     * @return minimal number
     */
    private static int findMin(int firstNumber, int secondNumber) {
        return firstNumber < secondNumber ? firstNumber : secondNumber;
    }

    // метод находит Наибольший Общий Делитель двух чисел
    private static int findNod(int firstNumber, int secondNumber) {
        int max = findMax(firstNumber, secondNumber);
        int min = findMin(firstNumber, secondNumber);

        for (int i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // метод находит Наименьшее Общее кратное двух чисел
    private static int findNok(int firstNumber, int secondNumber) {
        int max = findMax(firstNumber, secondNumber);
        int min = findMin(firstNumber, secondNumber);

        for (int i = max; i <= min * max; i++) {
            if (i % max == 0 && i % min == 0) {
                return i;
            }
        }
        return min * max;
    }

    // метод возвращает максимальную степень двойки числа
    private static int findMaxPowerOfTwo(int number) {
        int temp = 0;
        for (int i = 0; i < 32; i++) {
            if (Math.pow(2, i) > number) {
                temp = i - 1;
                break;
            }
        }

        return temp;
    }

    // метод разбивает число на уникальные цифры и возвращает
    // сумму степеней(этих уникальных чисел) двойки 32--2^3+2^2=12; 14--2^1+2^4=18; 11--2^1=2
    private static int calcNumeralToSumPowersOfTwo(int number) {
        if (number != 0) {
            int count = 0;
            int numeral;
            while (number != 0) {
                numeral = number % 10;
                if (!isNumberContainsInFullNumber(numeral, count)) {
                    count = (count + (int) Math.pow(2, numeral));
                    number /= 10;
                } else {
                    number /= 10;
                }
            }
            return count;
        } else {
            return 0;
        }
    }

    // метод проверяет есть ли указанная степень(searchNumber) в разложении второго числа(fullNumber) по степени двойки
    private static boolean isNumberContainsInFullNumber(int searchNumber, int fullNumber) {
        for (int i = findMaxPowerOfTwo(fullNumber); i >= 0; i--) {
            int maxPowerOfTwo = findMaxPowerOfTwo(fullNumber);
            fullNumber = fullNumber - (int) Math.pow(2, maxPowerOfTwo);

            if (searchNumber == maxPowerOfTwo) {
                return true;
            }
        }

        return false;
    }

    // метод высчитывает из суммы степеней двоек количество слагаемых этих степеней 11=2^0+2^1+2^3  (return 3;)
    private static int calcCountTermsFromSumPowersOfTwo(int fullNumber) {
        int count = 0;
        for (int i = findMaxPowerOfTwo(fullNumber); i >= 0; i--) {
            if (isNumberContainsInFullNumber(i, fullNumber)) {
                fullNumber = fullNumber - (int) Math.pow(2, findMaxPowerOfTwo(fullNumber));
                count++;
            }
        }
        return count;
    }
}








