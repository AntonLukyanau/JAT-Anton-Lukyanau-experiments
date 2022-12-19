package org.example.java8;

import org.example.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamToArray {
    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(1, 5, 9, 5);
        var myCollector = new ToArrayCollector();

        int[] intArray = source.stream().mapToInt(Integer::intValue).toArray();
        Object[] collect = source.toArray();

        Integer[] array = source.stream().toArray(Integer[]::new);
        Integer[] myArray = source.stream().collect(myCollector);


        Stream<Person> personStream = Stream.of(new Person(1, "name1", "surname1", "belarusian", "123456789PB5"),
                new Person(2, "name2", "surname2", "belarusian", "123246789PB5"),
                new Person(3, "name3", "surname3", "belarusian", "123436789PB5"),
                new Person(4, "name4", "surname4", "belarusian", "123464789PB5"),
                new Person(5, "name5", "surname5", "belarusian", "123467589PB5"));

        Person[] peopleArray = personStream.toArray(Person[]::new);
        for (Person person : peopleArray) {
            System.out.println(person);
        }
        int[] ints = IntStream.of(1, 2, 3, 4).toArray();

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }
}
