package org.example.iscompile;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton<T extends Number> {

//    public static T getInstance() {
//        if (instance == null)
//            instance = new Singleton<T>();
//        return instance;
//    }

    public static <E> E getElem(E elem) {
        Class<?> aClass = elem.getClass();
        try {
            Constructor<?> constructor = aClass.getConstructor();
            Object newInstance = constructor.newInstance();
            return (E) newInstance;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object instance = null;

}
