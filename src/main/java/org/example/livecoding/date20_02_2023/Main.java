package org.example.livecoding.date20_02_2023;

public class Main {
    public static void main(String[] args) {
//        RequestHandler handler = new RequestHandler();
//        handler.handleRequest(() -> System.out.println("some"));
        A obj = new B();
        System.out.println(obj.a);
    }
}

class A {
    int a = 5;
}

class B extends A {
    int a = 10;
}
