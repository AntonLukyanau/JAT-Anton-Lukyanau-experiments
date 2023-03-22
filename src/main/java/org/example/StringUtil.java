package org.example;

public class StringUtil {

    public static String generateString() {
        int length = (int) (Math.random() * 100);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (Math.random() * 28 + 'a'));
        }
        return stringBuilder.toString();
    }

}
