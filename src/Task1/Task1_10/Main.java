package Task1.Task1_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        char letter;
        System.out.println("Введите букву");
        letter = initializing();
        System.out.println(letter);
        System.out.println(checkVowel_1(Character.toLowerCase(letter)));
        System.out.println(checkVowel_2(Character.toLowerCase(letter)));
        System.out.println(checkVowel_3(Character.toLowerCase(letter)));
        System.out.println(checkVowel_4(Character.toLowerCase(letter)));
        System.out.println(checkVowel_5(Character.toLowerCase(letter)));
        System.out.println(checkVowel_6(Character.toLowerCase(letter)));
        System.out.println(checkVowel_7(Character.toLowerCase(letter)));
    }

    //метод инициализирует переменную типа char
    private static char initializing() {
        String input;

        while (true) {
            try {
                input = new Scanner(System.in).nextLine();
                if (input.length() == 1) {
                    return input.charAt(0);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода, введите корректное значение");
            }
        }
    }

    //метод №1 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_1(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'u' || letter == 'i' || letter == 'o' || letter == 'y';
    }

    //метод №2 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_2(char letter) {
        String vowels = "aeiuoy";
        String letterToString = String.valueOf(letter);
        return vowels.contains(letterToString);
    }

    //метод №3 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_3(char letter) {
        char[] vowels = {'a', 'e', 'i', 'u', 'o', 'y'};
        for (char vowel : vowels) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }

    //метод №4 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_4(char letter) {
        Letter lt = Letter.valueOf(String.valueOf(Character.toUpperCase(letter)));
        return lt.getType().equals(CharType.VOWEL);
    }

    //метод №5 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_5(char letter) {
        switch (letter) {
            case 'a':
            case 'e':
            case 'u':
            case 'i':
            case 'o':
            case 'y':
                return true;
            default:
                return false;
        }
    }

    //метод №6 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_6(char letter) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'u', 'o', 'y'));
        return vowels.contains(letter);
    }

    //метод №7 проверяет является ли введённая буква гласной английского алф.
    private static boolean checkVowel_7(char letter) {
        Pattern pattern = Pattern.compile("[aeiuoy]");
        Matcher matcher = pattern.matcher(String.valueOf(letter));
        return matcher.find();
    }
}




