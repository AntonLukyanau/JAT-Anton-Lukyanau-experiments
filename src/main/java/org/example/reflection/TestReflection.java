package org.example.reflection;

import java.lang.reflect.Constructor;

public class TestReflection {
    public static void main(String[] args) {
        try {
            Class<?> enumClass = Class.forName("org.example.serializable.SingletonEnum");
            for (Constructor<?> constructor : enumClass.getConstructors()) {
                System.out.println(constructor);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
