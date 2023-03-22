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
                new Employee("Alice", "HR", 0, 0),
                new Employee("Bob", "HR", 0, 0),
                new Employee("Charlie", "Sales", 0, 0),
                new Employee("Eve", "Sales", 0, 0)
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

