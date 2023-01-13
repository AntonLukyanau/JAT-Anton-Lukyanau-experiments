package org.example.reflection.copying.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final String surname;
    private final String patronymic;
    private final Address actualAddress;
    private final List<Address> addressHistory;

    public Person() {
        name = "Anton";
        surname = "Lukyanau";
        patronymic = "Olegovich";
        actualAddress = new Address(
                "Montenegro",
                "Budva",
                new Street("1th", 1,false, false),
                "S1",
                1);
        addressHistory = new ArrayList<>();
        addressHistory.add(actualAddress);
    }

    public Person(String name, String surname, String patronymic, Address actualAddress, List<Address> addressHistory) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.actualAddress = actualAddress;
        this.addressHistory = addressHistory;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Address getActualAddress() {
        return actualAddress;
    }

    public List<Address> getAddressHistory() {
        return new ArrayList<>(addressHistory);
    }
}
