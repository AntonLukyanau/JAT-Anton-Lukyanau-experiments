package org.example.types.topic;

public enum MyEnum {
    A(1), B(2), C(3);

    static {
        System.out.println("static block enum");
    }
    {
        System.out.println("non-static block enum");
    }
    int n;
    static int m;
    private MyEnum(int n) {
        this.n = n;
        System.out.println();
    }

    public void printStaticField() {
        System.out.println(m);
    }

}
