package org.example.collections;

import java.io.IOException;
import java.util.*;

public class SortedSetWithNullsAndComparable {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
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
            return this.hashCode() - o.hashCode();
        }
    }

}