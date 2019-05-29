package Task2.Task2_1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int MIN_THROWS_COUNT = 100;
        final int MAX_THROWS_COUNT = 10000;
        int countThrows = generateCountThrows(MIN_THROWS_COUNT, MAX_THROWS_COUNT);
        int countHeads = 0;
        int countTrails = 0;

        for (int i = 0; i < countThrows; i++) {
            if (isCoinHead()) {
                countHeads++;
            } else {
                countTrails++;
            }
        }

        System.out.println("Всего совершено " + countThrows + " бросков");
        System.out.println("Выпало " + countHeads + " орлов");
        System.out.println("Выпало " + countTrails + " решек");
        String formattedOutput = String.format("%.2f", countHeads * 1.00 / countThrows * 100) + "% /"
                + String.format("%.2f", countTrails * 1.00 / countThrows * 100) + "%";
        System.out.print("Соотношение орел/решка: " + formattedOutput);
    }

    //метод генерирует число бросков монеты
    private static int generateCountThrows(int minCount, int maxCount) {
        if (minCount > 0 && maxCount > minCount) {
            return new Random().nextInt(maxCount - minCount) + minCount;
        } else {
            System.out.println("Введен не корректный диапазон для генерации количества бросков");
            return 0;
        }
    }

    //метод генерирует бросок монеты и возвращает true, если выпал орел
    private static boolean isCoinHead() {
        return new Random().nextInt(2) == 1;
    }


}




