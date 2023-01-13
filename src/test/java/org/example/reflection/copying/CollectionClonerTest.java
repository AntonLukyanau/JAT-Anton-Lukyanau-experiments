package org.example.reflection.copying;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionClonerTest {

    @Test
    void cloneCollection_ShouldReturnCollectionWithSameType() {
        List<Integer> parameter = new ArrayList<>();
        CollectionCloner<Integer> cloner = new CollectionCloner<>();
        Collection<Integer> newCollection = cloner.cloneCollection(parameter);
        assertInstanceOf(parameter.getClass(), newCollection);
    }

    @Test
    void cloneCollection_ShouldReturnCollectionWithSameElements() {
        List<Integer> parameter = new ArrayList<>();
        CollectionCloner<Integer> cloner = new CollectionCloner<>();
        Collection<Integer> newCollection = cloner.cloneCollection(parameter);
        assertTrue(newCollection.containsAll(parameter) && parameter.containsAll(newCollection));
    }

    @Test
    void cloneCollection_ShouldWorkWithCustomCollection() {
        class MyList<T> extends ArrayList<T> {
            private MyList() {
                System.out.println("I have born");
            }

            public void sayHello() {
                System.out.println("hello");
            }
        }
        List<Integer> parameter = new MyList<>();
        CollectionCloner<Integer> cloner = new CollectionCloner<>();
        Collection<Integer> newCollection = cloner.cloneCollection(parameter);
        assertInstanceOf(parameter.getClass(), newCollection);
    }

    @Test
    void cloneCollectionUsingSerialization_ShouldReturnNewObject() {
        List<String> list = new ArrayList<>();
        list.add("One string");
        CollectionCloner<String> cloner = new CollectionCloner<>();
        Collection<String> collection = cloner.cloneCollection(list);
        assertNotSame(list, collection);
    }

}