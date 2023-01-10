package org.example.oop.immutability;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Person spouse;
    private final List<StringBuilder> contacts;

    public ImmutablePerson(String name, int age, Person spouse, List<StringBuilder> contacts) {
        this.name = name;
        this.age = age;
        this.spouse = spouse == null ? null : new Person(spouse);
        this.contacts = contacts == null ? new ArrayList<>() : deepCopy(contacts);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person getSpouse() {
        return new Person(spouse);
    }

    public List<StringBuilder> getContacts() {
        return deepCopy(contacts);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "\n\tname='" + name + '\'' +
                ", \n\tage=" + age +
                ", \n\tspouse=" + spouse +
                ", \n\tcontacts=" + contacts +
                '}';
    }

    private List<StringBuilder> deepCopy(List<StringBuilder> source) {
        return source.stream()
                .map(StringBuilder::new)
                .toList();
    }

}
