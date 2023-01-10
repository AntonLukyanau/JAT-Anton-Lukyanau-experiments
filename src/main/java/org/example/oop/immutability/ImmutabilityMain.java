package org.example.oop.immutability;

import org.example.model.Gender;
import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ImmutabilityMain {
    public static void main(String[] args) {
        Person katrine = new Person(Gender.FEMALE, "Katrine");
        List<StringBuilder> robertContacts = new ArrayList<>();
        robertContacts.add(new StringBuilder("+123456789"));
        robertContacts.add(new StringBuilder("robert_destroyer@epam.com"));

        ImmutablePerson robert = new ImmutablePerson("Robert", 25, katrine, robertContacts);
        System.out.println(robert);

        List<StringBuilder> gettedList = robert.getContacts();
        StringBuilder element = gettedList.get(0);
        element.append(" some ");


        System.out.println(robert);
    }
}
