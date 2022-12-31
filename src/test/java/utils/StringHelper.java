package utils;

import java.util.Random;

public class StringHelper {
    private static final Random RANDOM = new Random();

    public static String getRandomEnglishString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String getRandomRussianString(int length) {
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String getPhoneNumber() {
        int[] startNumeric = {4, 8, 9};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startNumeric[RANDOM.nextInt(2)]);
        for (int i = 0; i < 9; i++) {
            stringBuilder.append(RANDOM.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static String getMail() {
        String template = "%s@%s.%s";
        String[] domains = {"ru", "com"};

        return String
                .format(template,
                        getRandomEnglishString(RANDOM.nextInt(10) + 1),
                        getRandomEnglishString(RANDOM.nextInt(6) + 1),
                        domains[RANDOM.nextInt(1)]);
    }
}
