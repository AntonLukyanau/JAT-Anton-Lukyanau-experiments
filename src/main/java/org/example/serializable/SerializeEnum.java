package org.example.serializable;

import java.io.*;

public class SerializeEnum {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("enum.bin"));
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("enum.bin"))) {
            instance.setValue(4);
            System.out.println(instance);
            outputStream.writeObject(instance);
            instance.setValue(5);
            Object o = inputStream.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
