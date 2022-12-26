package org.example.multithreading;

public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(lock1, lock2));
        Thread thread2 = new Thread(new MyRunnable(lock2, lock1));

        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
        thread1.start();
        thread2.start();
//        while(true) {
//            System.out.println(thread1.getName() + " " + thread1.getState());
//            System.out.println(thread2.getName() + " " + thread2.getState());
//        }
    }
}

