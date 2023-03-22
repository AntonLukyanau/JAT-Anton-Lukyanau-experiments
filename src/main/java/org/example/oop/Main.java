package org.example.oop;

public class Main {
    public static void main(String[] args) {
        Child child = new Child(1,2,3);


        print(null);

    }

    public static void print(Parent obj) {
        System.out.println("SealedParent");
    }

    public static void print(Child obj) {
        System.out.println("Child");
    }

}
