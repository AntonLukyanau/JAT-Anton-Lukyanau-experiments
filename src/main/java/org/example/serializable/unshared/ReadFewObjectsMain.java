package org.example.serializable.unshared;

import org.example.serializable.vs.json.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFewObjectsMain {
    public static void main(String[] args) {
        Person person11 = null;
        Person person12 = null;
        Person person13 = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.ser"))) {
            System.out.println("Читаем первый раз объект 1");
            person11 = (Person) inputStream.readObject();
            System.out.println("Читаем первый раз объект 2");
            person12 = (Person) inputStream.readObject();
            System.out.println("Читаем первый раз объект 3");
            person13 = (Person) inputStream.readUnshared();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Person person21 = null;
        Person person22 = null;
        Person person23 = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.ser"))) {
            System.out.println("Читаем второй раз объект 1");
            person21 = (Person) inputStream.readObject();
            System.out.println("Читаем второй раз объект 2");
            person22 = (Person) inputStream.readObject();
            System.out.println("Читаем второй раз объект 3");
            person23 = (Person) inputStream.readUnshared();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1.1 == 1.2 = " + (person11 == person12));
        System.out.println("1.2 == 1.3 = " + (person12 == person13));
        System.out.println("1.1 == 1.3 = " + (person11 == person13));

        System.out.println("1.1 == 2.1 = " + (person11 == person21));
        System.out.println("1.1 == 2.2 = " + (person11 == person22));
        System.out.println("1.1 == 2.3 = " + (person11 == person23));

        System.out.println("1.2 == 2.1 = " + (person12 == person21));
        System.out.println("1.2 == 2.2 = " + (person12 == person22));
        System.out.println("1.2 == 2.3 = " + (person12 == person23));

        System.out.println("2.1 == 2.2 = " + (person21 == person22));
        System.out.println("2.1 == 2.3 = " + (person21 == person23));
        System.out.println("2.2 == 2.3 = " + (person22 == person23));
    }
}
