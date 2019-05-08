package Task1.Task1_9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int dragonAge, dragonHeads, dragonEyes;

        System.out.println("Введите возраст дракона");
        dragonAge = initializing();
        dragonHeads = countDragonHeads(dragonAge);
        dragonEyes = countDragonEyes(dragonHeads);

        System.out.println("у дракона " + dragonHeads + " голов и " + dragonEyes + " глаз");

    }

    //метод инициализирует переменную типа int > 0
    private static int initializing() {
        int count;

        while (true) {
            try {
                count = new Scanner(System.in).nextInt();
                if (count > 0) {
                    return count;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    // метод высчитывает количество голов дракона по возрасту
    private static int countDragonHeads(int dragonAge) {
        int dragonHeads = 3;

        if (dragonAge < 200) {
            dragonHeads = dragonHeads + dragonAge * 3;
        } else if (dragonAge < 300) {
            dragonHeads = dragonHeads + 200 * 3 + (dragonAge - 200) * 2;
        } else {
            dragonHeads = dragonHeads + 200 * 3 + 100 * 2 + (dragonAge - 300);
        }

        return dragonHeads;
    }

    // метод высчитывает количество глаз дракона по количеству голов
    private static int countDragonEyes(int dragonHeads) {
        return dragonHeads * 2;
    }
}




