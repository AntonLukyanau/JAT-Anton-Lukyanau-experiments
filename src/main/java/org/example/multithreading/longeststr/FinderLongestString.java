package org.example.multithreading.longeststr;

import java.util.concurrent.Callable;

public class FinderLongestString implements Callable<String> {
    private String[] range;

    public FinderLongestString(String[] range) {
        this.range = range;
    }

    @Override
    public String call() {
        String longestStringInRange = "";
        for (String s: range) {
            if (longestStringInRange.length() < s.length()) {
                longestStringInRange = s;
            }
        }
        return longestStringInRange;
    }
}
