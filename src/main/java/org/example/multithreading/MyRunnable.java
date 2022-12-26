package org.example.multithreading;

class MyRunnable implements Runnable {
    private final Object lock1;
    private final Object lock2;
    private int i;

    public MyRunnable(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        i = 0;
    }

    public void run() {
        while (true) {
            synchronized (lock1) {
                synchronized (lock2) {
                    // Код, который выполняется в синхронизированных блоках
                    System.out.println(i++);
                }
            }
        }
    }
}
