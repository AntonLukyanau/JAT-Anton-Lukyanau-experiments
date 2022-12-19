package org.example.oop;

public class Child extends Parent {

    private int a;
    private int b;
    private int c;
    private int d;

    public Child() {
        this(1,2,3,4);
        System.out.println("child without parameters");
    }

    public Child(int a) {
        this.a = a;
    }

    public Child(int a, int b) {
        this(a);
        this.b = b;
    }

    public Child(int a, int b, int c) {
        this(a, b);
        this.c = c;
    }

    public Child(int a, int b, int c, int d) {
        this(a, b, c);
        this.d = d;
    }

    public Child(String par) {
        System.out.println("child with str param");
    }

    @Override
    public String toString() {
        String first = "Child{";
        String s = super.toString() + "}";
        return first + s;
    }
}
