package org.example.collections;

import java.io.IOException;
import java.util.*;

/**
 Задача: Написать компаратор, который позволил бы TreeSet хранить null. Попробовать реализовать Comparable с той же целью.
 */
public class SortedSetWithNullsAndComparable {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        SortedSet<A> sortedSetWithNulls = new TreeSet<>((elem1, elem2) -> {
            if (elem1 == null && elem2 == null) {
                return 0;
            }
            if (elem1 == null){
                return -1;
            }
            if (elem2 == null) {
                return 1;
            }
            return elem1.hashCode() - elem2.hashCode();
        });
        sortedSetWithNulls.add(null);
        sortedSetWithNulls.add(null);
        System.out.println(sortedSetWithNulls);

        SortedSet<A> sortedSet = new TreeSet<>();
        sortedSet.add(null);
        sortedSet.add(null);
        System.out.println(sortedSet);
    }

    static class A implements Comparable<A> {
        @Override
        public int compareTo(A o) {
            if (o == null) {
                return 1;
            }
            return Objects.hash(this) - Objects.hash(o);
        }
    }

}