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

//    public SealedParent(String name) {
//        this.name = name;
//        System.out.println("SealedParent was successfully created");
//    }
    public Parent() {
        System.out.println("parent without params");
    }

    public long getInt() {
        return 1;
    }

    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
