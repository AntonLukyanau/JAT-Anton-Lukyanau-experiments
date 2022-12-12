package org.example.collections;

import java.util.LinkedList;

public class LinkedListWithNulls {
    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(null);
        objects.add(null);
        objects.forEach(System.out::println);
    }
}
