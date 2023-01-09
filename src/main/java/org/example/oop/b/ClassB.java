package org.example.oop.b;

import org.example.oop.a.ClassA;

public class ClassB extends ClassA {
    int i = 2;
    public ClassB() {
        System.out.println(getI());
    }
    public int getI() {
        return i;
    }
}
