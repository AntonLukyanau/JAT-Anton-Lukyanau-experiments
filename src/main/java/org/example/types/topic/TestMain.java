package org.example.types.topic;

public class TestMain {
    public static void main(String[] args) {
        MyEnum a = MyEnum.A;
        MyEnum b = MyEnum.B;
        a.n = 10;
        System.out.println(a.n);
        System.out.println(b.n);
    }
}
