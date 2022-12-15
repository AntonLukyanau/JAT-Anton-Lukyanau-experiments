package org.example.serializable.vs.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestJsonParsing {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try (JsonParser parser = mapper.createParser(new File("person.json"))) {
            long start = System.currentTimeMillis();
            Person person = parser.readValueAs(Person.class);
            long end = System.currentTimeMillis();
            System.out.println(person);
            System.out.println("JSON parsing was completed with " + (end - start) + " ms");//approximately 60 ms
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
