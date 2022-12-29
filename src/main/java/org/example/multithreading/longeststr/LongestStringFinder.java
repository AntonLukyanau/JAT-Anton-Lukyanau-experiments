package org.example.multithreading.longeststr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class LongestStringFinder {

    private final String[] strings;
    private final AtomicReference<String> longestStringHolder;
    private ExecutorService executorService;
    private String longestString;
    private boolean isFound;

    public LongestStringFinder(final String[] strings) {
        if (strings == null) {
            throw new IllegalArgumentException("Array is null");
        }
        this.strings = new String[strings.length];
        System.arraycopy(strings, 0, this.strings, 0, strings.length);
        this.longestStringHolder = new AtomicReference<>();
        this.longestString = strings.length > 0 ? strings[0] : null;
        this.isFound = false;
    }

    public String findLongestString() {
        if (isFound)
            return longestString;
        int countThread = Runtime.getRuntime().availableProcessors();
        int elementsPerThread = strings.length / countThread;
        executorService = Executors.newFixedThreadPool(countThread);
        List<Future<String>> tasksResults = submitTasks(countThread, elementsPerThread);
        for (Future<String> tasksResult : tasksResults) {
            try {
                tasksResult.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        longestString = longestStringHolder.get();
        isFound = true;
        return longestString;
    }

    private List<Future<String>> submitTasks(int countThread, int elementsPerThread) {
        List<Future<String>> tasksResults = new ArrayList<>(countThread);
        for (int i = 0; i < countThread - 1; i++) {
            FindLongestStringTask task = new FindLongestStringTask(
                    Arrays.copyOfRange(strings, elementsPerThread * i, elementsPerThread * (i + 1)),
                    longestStringHolder);
            tasksResults.add(executorService.submit(task));
        }
        FindLongestStringTask task = new FindLongestStringTask(
                Arrays.copyOfRange(strings, elementsPerThread * (countThread - 1), strings.length),
                longestStringHolder);
        tasksResults.add(executorService.submit(task));
        return tasksResults;
    }

}
