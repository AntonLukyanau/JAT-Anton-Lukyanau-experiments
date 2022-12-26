package org.example.multithreading.longeststr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultiLongestStringThreadManager {

    public static String findLongestString(String[] strings) {
        int countThread = Runtime.getRuntime().availableProcessors();
        int arrayLength = strings.length;
        int elementsPerThread = arrayLength / countThread;
        List<Future<String>> tasksResults = new ArrayList<>(countThread);
        ExecutorService executorService = Executors.newFixedThreadPool(countThread);
        for (int i = 0; i < countThread - 1; i++) {
            FinderLongestString task = new FinderLongestString(
                    Arrays.copyOfRange(strings, elementsPerThread * i, elementsPerThread * (i + 1)));
            tasksResults.add(executorService.submit(task));
        }
        FinderLongestString task = new FinderLongestString(
                Arrays.copyOfRange(strings, elementsPerThread * (countThread - 1), strings.length));
        tasksResults.add(executorService.submit(task));
        String longestString = null;
        for (Future<String> tasksResult : tasksResults) {
            try {
                String result = tasksResult.get();
                if (longestString == null || longestString.length() < result.length()) {
                    longestString = result;
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        return longestString;
    }

}
