package org.example.sealedexpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public sealed class B permits A, C {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 1, 4, 5, 2);
//        numbers.sort(Comparator.reverseOrder());

        Comparator<Integer> comparator = (i1, i2) -> i2 - i1;
        numbers.stream().sorted(comparator.reversed()).forEach(System.out::println);
//        System.out.println(numbers);
    }


    public static <T extends Comparable<T>> T max(T x, T y) {

        return x.compareTo(y) > 0 ? x : y;

    }

}
