package org.example.oop;

public class EarlyWeiring {
    public static void main(String[] args) {
        A bLikeA = new B();
        bLikeA.print();
        B b = new B();
        b.doSome();
        System.out.println();
        int i = 0;
        int hernja = (i = i + 1);
        int postfix = i++;
        int prefix = ++i;

        System.out.println(postfix);
        System.out.println(prefix);
        System.out.println(hernja);

        Object[] objects = new Object[2];
        Number[] numbers = new Number[3];
        objects = numbers;

    }
}

class A implements Comparable<A> {
    public void print() {
        System.out.println("A");
    }

    public static void doSome() {
        System.out.println("static A");
    }

    @Override
    public int compareTo(A o) {
        if (o == null) {
            return 1;
        }
        return this.hashCode() - o.hashCode();
    }
}

class B extends A {
    public static void doSome() {
        System.out.println("static B");
    }
    @Override
    public final void print() {
        System.out.println("B");
    }

}
