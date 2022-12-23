package org.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WaysToCreateStream {
    public static void main(String[] args) {
        Stream<Object> stream = Stream.builder()
                .add("")
                .add("1")
                .add(4)
                .add(3f)
                .add(1L)
                .add(null)
                .add(new Object())
                .build();
        long count = stream.count();

        List<String> list = Arrays.asList("sdc", "asx", "2e");
        Stream<String> streamBySupport = StreamSupport.stream(list.spliterator(), false);
        long count1 = streamBySupport.count();

        //можно получить сплитератор для бесконечного количества элементов
//        Stream<Integer> infiniteIterateStream = Stream.iterate(1, element -> element + 2);
//        Spliterator<Integer> infiniteSpliterator = infiniteIterateStream.spliterator();
//        infiniteSpliterator.forEachRemaining(System.out::println);

        Stream<Integer> iterateStream = Stream.iterate(1, element -> element + 2);
        //если не ставить limit, то будет бесконечно выполняться
        iterateStream.limit(15).forEach(System.out::println);
        System.out.println("--------------");
        Stream<Integer> generateStream = Stream.generate(() -> (int) (Math.random() * 90 + 10));

        Spliterator<Integer> spliterator = generateStream.peek(System.out::println).limit(10).spliterator();
        //TODO выяснить почему не выходит разбить сплитератор на два
//        StreamSupport.stream(spliterator.trySplit(), false)
//                .forEach(System.out::println);
        long count2 = StreamSupport.stream(spliterator, false).count();
        System.out.println(count2);


    }
}
