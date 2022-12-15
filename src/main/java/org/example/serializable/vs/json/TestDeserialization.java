package org.example.serializable.vs.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeserialization {
    public static void main(String[] args) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.bin"))) {
            long start = System.currentTimeMillis();
            Person person = (Person) inputStream.readObject();
            long end = System.currentTimeMillis();
            System.out.println(person);
            System.out.println("Deserialization was completed with " + (end - start) + " ms");//approximately 18 ms
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
