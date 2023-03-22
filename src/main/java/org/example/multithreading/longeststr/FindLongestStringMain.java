package org.example.multithreading.longeststr;

import org.example.StringUtil;

import java.util.Arrays;

/**
 Задача1: Реализовать генерацию строки случайной длины содержащую случайные буквы латинского алфавита
 Задача2: Реализовать поиск самой длинной строки в массиве.
            Для улучшения производительности использовать многопоточность
 */
public class FindLongestStringMain {

    public static void main(String[] args) {
        String[] strings = new String[(int) (Math.random() * 500)];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = StringUtil.generateString();
        }
        LongestStringFinder stringFinder = new LongestStringFinder(strings);
        String longestString = stringFinder.findLongestString();
        System.out.println(longestString + "\n");

        Arrays.sort(strings, (str1, str2) -> str2.length() - str1.length());
        for (int i = 0; i < 5; i++) {
            System.out.println(strings[i]);
        }

    }
}
