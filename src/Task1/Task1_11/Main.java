package Task1.Task1_11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> date = initializing();
        date = calcNextDay(date);
        if (date != null) {
            System.out.print("Новая дата:");
            System.out.println(date.get(0) + "/" + date.get(1) + "/" + date.get(2));
        }

    }

    //метод инициализирует три числа, год/месяц/день (формат 2000/12/31) для формирования даты
    private static ArrayList<Integer> initializing() {
        int year, month, day;
        ArrayList<Integer> date = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Введите год");
                year = new Scanner(System.in).nextInt();
                System.out.println("Введите месяц");
                month = new Scanner(System.in).nextInt();
                System.out.println("Введите день");
                day = new Scanner(System.in).nextInt();

                if (checkDate(year, month, day)) {
                    System.out.println("Вы ввели дату: " + year + "/" + month + "/" + day);
                    date.add(year);
                    date.add(month);
                    date.add(day);
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
        return date;
    }

    //метод проверяет является ли год високосным
    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 == 0) {
            return false;
        } else return year % 4 == 0;

    }

    //метод проверяет корректна ли дата
    private static boolean checkDate(int year, int month, int day) {
        if (!(year > 0 && month > 0 && month <= 12 && day > 0 && day <= 31)) {
            return false;
        }

        if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            return false;
        }

        if (day > 29 && month == 2) {
            return false;
        }

        if (day == 29 && month == 2 && !checkLeapYear(year)) {
            return false;
        }

        return true;
    }

    //метод возвращает дату следующего дня
    private static ArrayList<Integer> calcNextDay(ArrayList<Integer> date) {
        int year = date.get(0);
        int month = date.get(1);
        int day = date.get(2);

        if (day < 28) {
            day += 1;
            date.set(2, day);
            return date;
        }

        if (day == 28 && month == 2 && checkLeapYear(year)) {
            day += 1;
            date.add(2, day);
            return date;
        } else if ((day == 28 && month == 2 && !checkLeapYear(year))
                || (day == 29 && month == 2 && checkLeapYear(year))) {
            day = 1;
            month = 3;
            date.set(1, month);
            date.set(2, day);
            return date;
        }

        if ((day == 30 && (month == 4 || month == 6 || month == 9 || month == 11))
                || (day == 31 && month != 12)) {
            day = 1;
            month += 1;
            date.set(1, month);
            date.set(2, day);
            return date;
        } else if (day == 30) {
            day += 1;
            date.add(2, day);
            return date;
        }

        if (day == 31) {
            day = 1;
            month = 1;
            year += 1;
            date.set(0, year);
            date.set(1, month);
            date.set(2, day);
            return date;
        }

        return null;
    }

}




