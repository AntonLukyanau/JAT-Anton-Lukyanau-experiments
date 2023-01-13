package org.example.reflection.copying;

import java.io.*;
import java.util.Collection;

/**
 Задача: напишите метод, который получает в качестве параметра Collection<T>,
 а возвращает копию этой коллекции с тему же элементами.
 Ограничения: скопированная коллекция должна быть того же класса, что и входящая.
    Т.е. collection.getClass() и copy.getClass() должны возвращать одно и то же
 */
public class CollectionCloner<T> {

    public Collection<T> cloneCollection(Collection<T> collection) {
        StructureCloner structureCloner = new StructureCloner();
        Collection<T> newCollection = (Collection<T>) structureCloner.createEmptyInstanceByClass(collection.getClass());
        newCollection.addAll(collection);
        return newCollection;
//        return cloneCollectionUsingSerialization(collection);
    }

    public Collection<? extends Serializable> cloneCollectionUsingSerialization(Collection<? extends Serializable> collection) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeUnshared(collection);
            oos.flush();
            byte[] collectionAsBytes = byteArrayOutputStream.toByteArray();
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(collectionAsBytes));
            Object newCollection = ois.readUnshared();
            ois.close();
            if (newCollection instanceof Collection<?>) {
                return (Collection<? extends Serializable>) newCollection;
            }
            throw new RuntimeException("");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
