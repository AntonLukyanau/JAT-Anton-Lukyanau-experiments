package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Задача: Есть шахматная доска размера NxM. Фигура находиться в верхнем левом углу доски и может двигаться
 * только ВНИЗ или ВПРАВО на одну клетку. Вопрос: сколько способов добраться до нижнего правого угла доски существует?
 * P.S. Из-за производительности решать лучше не используя многопоточность, но потренить её на этом примере можно.
 */
public class Multithreading {
    public static final int N = 12000;
    public static final int M = 13000;
    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    static volatile long[][] desk;
    private static AtomicInteger row = new AtomicInteger(1);

    //TODO: сделать "ворота" на desk.length потоков, чтобы все потоки начинали одновременно
    //TODO:
    public static void main(String[] args) throws InterruptedException {
        int n = N;
        int m = M;
        boolean multiThreadingTurn = false;
        for (int test = 0; test < 16; test++) {
            desk = new long[n][m];
            for (int i = 0; i < n; i++) {
                desk[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                desk[0][i] = 1;
            }
            if (multiThreadingTurn) {
                fillArrayAsync();
                row.set(1);
            } else {
                fillArray();
            }
            multiThreadingTurn = !multiThreadingTurn;

            System.out.printf("Добраться до нижнего правого угла можно %d способами%n", desk[n - 1][m - 1]);
            Thread.sleep(2000);
        }
    }

    private static void fillArray() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < desk.length; i++) {
            for (int j = 1; j < desk[i].length; j++) {
                desk[i][j] = desk[i - 1][j] + desk[i][j - 1];
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Without multithreading: " + (end - start) + " ms");
    }


    private static void fillArrayAsync() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= THREAD_COUNT; i++) {
            threads.add(new Thread(new FillColumnThread(desk, i)));
        }
        Thread thread = threads.get(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            thread = threads.get(i);
            thread.start();
        }
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println("WITH multithreading: " + (end - start) + " ms");
    }

    static class FillColumnThread implements Runnable {
        private int workRow;
        private final long[][] desk;

        public FillColumnThread(long[][] desk, int workRow) {
            super();
            this.workRow = workRow;
            this.desk = desk;
        }

        @Override
        public void run() {
            while(workRow < desk.length) {
                for (int i = 1; i < desk[workRow].length; i++) {
                    if (desk[workRow - 1][i] == 0) {
                        Thread.yield();
                        i--;
                    } else {
                        desk[workRow][i] = desk[workRow - 1][i] + desk[workRow][i - 1];
                    }
                }
                workRow = row.getAndIncrement();
            }
        }
    }

}
