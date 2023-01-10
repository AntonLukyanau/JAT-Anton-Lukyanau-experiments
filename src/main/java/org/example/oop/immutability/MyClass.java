package org.example.oop.immutability;

import org.example.model.Person;

public class MyClass {
    private String id;
    private Person parent;

    public MyClass() {
    }

    public MyClass(MyClass myClass) {
        this.id = myClass.id;
        this.parent = myClass.parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }
}
