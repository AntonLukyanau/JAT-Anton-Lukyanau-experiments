package org.example.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ListToMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("qqq", "www", "eee", "qqq", "eee", "qqq", "qqq", "qqq");


//        Map<String, Integer> map = null;
//
//        map = list.stream()
//                .collect(Collectors.toMap(
//                        element -> element, //key
//                        i -> 1,                //value
//                        (oldVal, income) -> oldVal + income                //соединение при повторной встрече элемента
//                ));
        int решение;
//        Map<String, Integer> map = list.stream()
//                .collect(Collectors.toMap(
//                        str -> str,
//                        val -> 1,
//                        Integer::sum));
        int решение_для_объяснения;
//        Map<String, Integer> map = list.stream()
//                .collect(Collectors.toMap(
//                        str -> str,
//                        val -> 1,
//                        (oldVal, income) -> oldVal + income));
        int решение_с_дебагом;
//        Map<String, Integer> map = list.stream()
//                .collect(Collectors.toMap(
//                        str -> str,
//                        val -> 1,
//                        (oldVal, income) -> {
//                            System.out.println("oldVal " + oldVal);
//                            System.out.println("income " + income);
//                            System.out.println();
//                            return oldVal + income;
//                        }));
//        System.out.println(map);

    }
}
