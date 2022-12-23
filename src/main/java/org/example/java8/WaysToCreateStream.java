package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WaysToCreateStream {
    public static void main(String[] args) {
        Stream<Object> stream = Stream.builder()
                .add("")
                .add("1")
                .add(4)
                .add(1L)
                .add(new Object())
                .build();
        long count = stream.count();

        List<String> list = Arrays.asList("sdc", "asx", "2e");
        Stream<String> streamBySupport = StreamSupport.stream(list.spliterator(), false);
        long count1 = streamBySupport.count();

        Stream<Integer> iterateStream = Stream.iterate(1, element -> element + 2);
        //если не ставить limit то будет бесконечно выполняться
        iterateStream.limit(15).forEach(System.out::println);
        System.out.println("--------------");
        Stream<Integer> generateStream = Stream.generate(() -> (int) (Math.random() * 90 + 10));
        generateStream.limit(10).forEach(System.out::println);


    }
}
