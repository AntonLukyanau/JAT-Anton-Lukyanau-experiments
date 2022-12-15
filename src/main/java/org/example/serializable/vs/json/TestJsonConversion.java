package org.example.serializable.vs.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestJsonConversion {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .id(1)
                .name("Tom")
                .surname("Smith")
                .identityNumber("123456789PB5")
                .nationality("Belarusian")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        try (FileOutputStream outputStream = new FileOutputStream("person.json")) {
            long start = System.currentTimeMillis();
            outputStream.write(mapper.writeValueAsBytes(person));
            long end = System.currentTimeMillis();
            System.out.println("JSON conversion was completed with " + (end - start) + " ms");//approximately 56 ms
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
