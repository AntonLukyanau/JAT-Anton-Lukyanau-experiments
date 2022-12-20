package org.example.serializable.unshared;

import org.example.serializable.vs.json.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteFewObjectsMain {
    public static void main(String[] args) {
        Person person = Person.builder()
                .id(1111)
                .name("Tom")
                .surname("Smith")
                .identityNumber("123456789PB5")
                .nationality("Belarusian")
                .build();
        try (ObjectOutputStream outputStream1 = new ObjectOutputStream(new FileOutputStream("person.ser"))) {

            outputStream1.writeObject(person);
            outputStream1.writeObject(person);

            outputStream1.writeUnshared(person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
