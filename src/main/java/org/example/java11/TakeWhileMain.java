package org.example.java11;

import org.example.model.Gender;
import org.example.model.Person;

import java.util.Optional;
import java.util.stream.Stream;

public class TakeWhileMain {
    public static void main(String[] args) {
        Stream<Person> vasia = Stream.iterate(new Person(Gender.MALE, "Vasia"), person -> {
            Gender gender;
            switch (person.getGender()) {
                case MALE -> gender = Gender.FEMALE;
                case FEMALE -> gender = Gender.OTHER;
                default -> gender = Gender.MALE;
            }
            return new Person(gender, person.getName());
        }).limit(100);
        Stream<Person> vasia2 = Stream.iterate(new Person(Gender.MALE, "Vasia"), person -> {
            Gender gender;
            switch (person.getGender()) {
                case MALE -> gender = Gender.FEMALE;
                case FEMALE -> gender = Gender.OTHER;
                default -> gender = Gender.MALE;
            }
            return new Person(gender, person.getName());
        }).limit(100);

        System.out.println("takeWhile:");
        vasia.takeWhile(person -> person.getGender() != Gender.OTHER).forEach(System.out::println);
        System.out.println("\ndropWhile:");
        vasia2.dropWhile(person -> person.getGender() != Gender.OTHER).forEach(System.out::println);

        Optional<String> s = Optional.of("");
    }
}
