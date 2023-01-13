package org.example.reflection.copying;

import org.example.reflection.copying.model.Address;
import org.example.reflection.copying.model.Person;
import org.example.reflection.copying.model.Street;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullCopyClonerTest {

    @Test
    void deepCopy_shouldReturnNewObject() {
        Person person = new Person();
        FullCopyCloner cloner = new FullCopyCloner();
        Object o = cloner.deepCopy(person);
        assertNotSame(person, o);
    }

    @Test
    void deepCopy_shouldReturnObjectWithSameStructure() {
        Street street = new Street("StreetName", 2, true, true);
        Street street2 = new Street("StreetName2", 3, true, false);
        Address actualAddress = new Address("Country", "City", street, "House", 333);
        Address oldAddress = new Address("Country", "AnotherCity", street2, "AnotherHouse", 22);
        List<Address> addressList = new ArrayList<>();
        addressList.add(actualAddress);
        addressList.add(oldAddress);
        Person person = new Person("Name", "Surname", "Patronymic", actualAddress, addressList);

        FullCopyCloner cloner = new FullCopyCloner();
        Person newPerson = (Person) cloner.deepCopy(person);

        assertNotNull(newPerson.getName());
        assertNotNull(newPerson.getSurname());
        assertNotNull(newPerson.getPatronymic());

        Address newActualAddress = newPerson.getActualAddress();
        checkAddressStructure(newActualAddress);

        List<Address> newPersonAddressHistory = newPerson.getAddressHistory();
        assertNotNull(newPersonAddressHistory);
        assertEquals(addressList.size(), newPersonAddressHistory.size());
        newPersonAddressHistory.forEach(this::checkAddressStructure);
    }

    private void checkAddressStructure(Address address) {
        assertNotNull(address);
        assertNotNull(address.getStreet());
    }

    @Test
    void deepCopy_() {
        Street street = new Street("StreetName", 2, true, true);
        Street street2 = new Street("StreetName2", 3, true, false);
        Address actualAddress = new Address("Country", "City", street, "House", 333);
        Address oldAddress = new Address("Country", "AnotherCity", street2, "AnotherHouse", 22);
        List<Address> addressList = new ArrayList<>();
        addressList.add(actualAddress);
        addressList.add(oldAddress);
        Person person = new Person("Name", "Surname", "Patronymic", actualAddress, addressList);

        FullCopyCloner cloner = new FullCopyCloner();
        Person newPerson = (Person) cloner.deepCopy(person);

        assertEquals(person.getName(), newPerson.getName());
        assertEquals(person.getSurname(), newPerson.getSurname());
        assertEquals(person.getPatronymic(), newPerson.getPatronymic());
        assertEquals(person.getActualAddress(), newPerson.getActualAddress());
    }

}