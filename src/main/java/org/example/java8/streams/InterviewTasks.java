package org.example.java8.streams;

import org.example.model.Employee;
import org.example.model.Gender;
import org.example.model.Person;

import java.util.*;

public class InterviewTasks {
    public static void main(String[] args) {
        Map<Long, String> employees = Map.of(
                123L, "Alice",
                124L, "Bob",
                125L, "Charlie"
        );
        Optional<Map.Entry<Long, String>> charlieOptional = employees.entrySet().stream()
                .filter(pair -> "Charlie".equals(pair.getValue()))
                .findAny();

        List<Employee> employeeList = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "HR"),
                new Employee("Charlie", "Sales"),
                new Employee("Eve", "Sales")
        );

        int hrCount = (int) employeeList.stream()
                .filter(person -> "HR".equals(person.department()))
                .count();

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(Gender.MALE, "Alex"),
                new Person(Gender.FEMALE, "Andra"),
                null,
                new Person(Gender.FEMALE, "Alexia")
        ));

        List<String> femaleUpperCaseNames = people.stream()
                .filter(Objects::nonNull)
                .filter(person -> Gender.FEMALE == person.getGender())
                .map(person -> person.getName().toUpperCase())
                .toList();
    }
}

