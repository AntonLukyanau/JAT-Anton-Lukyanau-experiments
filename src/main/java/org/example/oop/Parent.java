package org.example.oop;

public class Parent {

    private static final String privateStaticConstant = "A";
    static final String packagePrivateStaticConstant = "A";
    protected static final String protectedStaticConstant = "A";
    public static final String publicStaticConstant = "A";

    private final String privateConstant = "A";
    final String packagePrivateConstant = "A";
    protected final String protectedConstant = "A";
    public final String publicConstant = "A";

    private String name;

//    public Parent(String name) {
//        this.name = name;
//        System.out.println("Parent was successfully created");
//    }
    public Parent() {
        System.out.println("parent without params");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
