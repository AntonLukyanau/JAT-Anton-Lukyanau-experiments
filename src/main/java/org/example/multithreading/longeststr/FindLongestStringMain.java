package org.example.multithreading.longeststr;

import java.util.Arrays;

public class FindLongestStringMain {

    public static void main(String[] args) {
        String[] strings = new String[(int) (Math.random() * 500)];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = generateString();
        }
        LongestStringFinder stringFinder = new LongestStringFinder(strings);
        String longestString = stringFinder.findLongestString();
        System.out.println(longestString + "\n");

        Arrays.sort(strings, (str1, str2) -> str2.length() - str1.length());
        for (int i = 0; i < 5; i++) {
            System.out.println(strings[i]);
        }

    }

    private static String generateString() {
        int length = (int) (Math.random() * 100);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (Math.random() * 28 + 92));
        }
        return stringBuilder.toString();
    }
}
