package org.example.collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetHeapPollution {
    public static void main(String[] args) {
        Set<Number> set = new TreeSet<>((v1, v2) -> v1.hashCode() - v2.hashCode());
        set.add(1);
        set.add(1L);
        set.add(1.0);
        System.out.println(set.size());
    }
}
