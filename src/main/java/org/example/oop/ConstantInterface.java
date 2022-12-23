package org.example.oop;

public class ConstantInterface {
    public static void main(String[] args) {
        BB b = new BB();
        AA a = b;
        b.m1();
        System.out.println(b.x);
        a.m1();
        System.out.println(a.x);
        System.out.println(b.y);
    }
}

interface AA {
    int x = 10;

    void m1();
}

class BB implements AA {
    static int y = 11;
    int x = 20;

    public void m1() {
        System.out.println(x);
    }
}
