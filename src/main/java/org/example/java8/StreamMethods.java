package org.example.java8;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMethods {
    public static void main(String[] args) {
        Stream<Object> stream = Stream.of("", new Object(), 1L, 3, "hello");
        //если не указывать identity, то accumulator будет первый элемент в стриме
        Object reduce = stream.reduce(0, (accumulator, elem) -> accumulator.hashCode() + elem.hashCode());
        System.out.println(reduce);

        Stream<String> stream2 = Stream.of(
                "11q",
                "222",
                "3q3q3",
                "4r4r4r",
                "45555",
                "6666",
                "7777",
                "8888"
        ).unordered();

        stream2.parallel().filter(str -> str.length() >= 4).forEach(System.out::println);

        Map<Long, String> employees = Map.of(
                123L, "Alice",
                124L, "Bob",
                125L, "Charlie"
        );
        Optional<Map.Entry<Long, String>> charlieOptional = employees.entrySet().stream()
                .filter(pair -> "Charlie".equals(pair.getValue()))
                .findAny();



    }
}
