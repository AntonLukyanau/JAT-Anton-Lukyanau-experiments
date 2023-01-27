package org.example.exceptions;

public class ExceptionStarter {
    public static void main(String[] args) {
        System.out.println(tryCatchFinallyReturn());
        try {
            tryCatchFinallyThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        doSome();
    }

    public static void doSome() {
        try {
            doSome();
        } catch (StackOverflowError e) {
            doSome();
//            e.printStackTrace();
        }
    }

    public static String tryCatchFinallyReturn() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return "catch";
        } finally {
            return "finally";
        }
    }

    public static String tryCatchFinallyThrow() {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new IllegalArgumentException("from catch");
        } finally {
            throw new UnsupportedOperationException("from finally");
        }
    }
}
