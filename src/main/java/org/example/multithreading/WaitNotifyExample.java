package org.example.multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1: holding lock");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: lock released");
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2: holding lock");
                lock.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 2: lock released");
            }
        });

        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}
