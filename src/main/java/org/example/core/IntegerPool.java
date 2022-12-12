package org.example.core;

public class IntegerPool {
    public static void main(String[] args) {
        //vm option: -XX:AutoBoxCacheMax=200
        Integer first = 150;
        Integer second = 150;
        System.out.println(first == second);
    }
}
