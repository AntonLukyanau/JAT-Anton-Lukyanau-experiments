package org.example.oop;

public class Parent {
    private String name;

//    public Parent(String name) {
//        this.name = name;
//        System.out.println("Parent was successfully created");
//    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
