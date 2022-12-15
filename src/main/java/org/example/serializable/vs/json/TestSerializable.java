package org.example.serializable.vs.json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerializable {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .id(1)
                .name("Tom")
                .surname("Smith")
                .identityNumber("123456789PB5")
                .nationality("Belarusian")
                .build();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            long start = System.currentTimeMillis();
            outputStream.writeObject(person);
            long end = System.currentTimeMillis();
            System.out.println("Serialization was completed with " + (end - start) + " ms");//approximately 22 ms
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
