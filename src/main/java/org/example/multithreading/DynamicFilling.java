package org.example.multithreading;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Задача: Есть шахматная доска размера NxM. Фигура находиться в верхнем левом углу доски и может двигаться
 * только ВНИЗ или ВПРАВО на одну клетку. Вопрос: сколько способов добраться до нижнего правого угла доски существует?
 * P.S. Для наилучшей производительности используйте многопоточность
 */
public class DynamicFilling {
    //случайное число от 1000 до 10_000
    public static final int N = (int) (Math.random() * 9000 + 1000);
    public static final int M = (int) (Math.random() * 9000 + 1000);
    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
//    private static CountDownLatch countDownLatch;

    private static volatile long[][] desk;
    private static final AtomicInteger row = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        boolean multiThreadingTurn = false;
        System.out.printf("Массив %d x %d\n", N, M);
        System.out.printf("Используется %d потоков\n", THREAD_COUNT);
        for (int test = 0; test < 16; test++) {
            resetDesk();
//            countDownLatch = new CountDownLatch(THREAD_COUNT);
            long passedTime = multiThreadingTurn ? fillArrayAsync() : fillArray();
            multiThreadingTurn = !multiThreadingTurn;
            System.out.println(passedTime + " ms");
            System.out.printf("Добраться до нижнего правого угла можно %d способами\n", desk[N - 1][M - 1]);
            Thread.sleep(2000);
        }
    }

    private static void resetDesk() {
        desk = new long[N][M];
        for (int i = 0; i < N; i++) {
            desk[i][0] = 1;
        }
        for (int i = 0; i < M; i++) {
            desk[0][i] = 1;
        }
    }

    private static long fillArray() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < desk.length; i++) {
            for (int j = 1; j < desk[i].length; j++) {
                desk[i][j] = desk[i - 1][j] + desk[i][j - 1];
            }
        }
        long end = System.currentTimeMillis();
        System.out.print("Without multithreading: ");
        return end - start;
    }

    private static long fillArrayAsync() throws InterruptedException {
        row.set(1);
        List<Thread> threads = new ArrayList<>();
        for (int emptyRowNum = 1; emptyRowNum <= THREAD_COUNT; emptyRowNum++) {
            threads.add(new Thread(new FillColumnTask(desk, emptyRowNum)));
        }
        Thread thread = threads.get(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            thread = threads.get(i);
            thread.start();
        }
        thread.join();
        long end = System.currentTimeMillis();
        System.out.print("WITH multithreading: ");
        return end - start;
    }

    static class FillColumnTask implements Runnable {
        private int workRow;
        private final long[][] desk;

        public FillColumnTask(long[][] desk, int workRow) {
            super();
            this.workRow = workRow;
            this.desk = desk;
        }

        @Override
        public void run() {
//            countDownLatch.countDown();
//            long downLatchCount = countDownLatch.getCount();
//            try {
//                countDownLatch.await();
//                System.out.printf("Поток %s ждал %d потоков\n", Thread.currentThread().getName(), downLatchCount);
            while (workRow < desk.length) {
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
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

}
