package org.example;

import java.io.IOException;
import java.util.*;

public class CollectionsExperiments {

    private int a = 1;

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        LinkedList<Object> objects = new LinkedList<>();
        objects.add(null);
        objects.add(null);
        objects.forEach(System.out::println);

        Set<Number> set = new TreeSet<>((v1, v2) -> v1.hashCode() - v2.hashCode());
        set.add(1);
        set.add(1L);
        set.add(1.0);
        System.out.println(set.size());

        SortedSet<A> sortedSet = new TreeSet<>();
//        sortedSet.add(null);
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