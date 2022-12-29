package org.example.multithreading.longeststr;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public class FindLongestStringTask implements Callable<String> {
    private final String[] range;
    private final AtomicReference<String> longestString;

    public FindLongestStringTask(String[] range, AtomicReference<String> longestString) {
        this.range = range;
        this.longestString = longestString;
    }

    @Override
    public String call() {
        String longestStringInRange = "";
        for (String s : range) {
            if (s != null && longestStringInRange.length() < s.length()) {
                longestStringInRange = s;
            }
        }
        if (longestString.get() == null || longestStringInRange.length() > longestString.get().length()) {
            longestString.set(longestStringInRange);
        }
        return longestStringInRange;
    }
}
