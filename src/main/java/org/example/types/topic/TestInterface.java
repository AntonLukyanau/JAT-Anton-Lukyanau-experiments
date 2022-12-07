package org.example.types.topic;

public interface TestInterface {
    static int notPublicButActuallyPublic = 0;
    public int nonStaticButActuallyStatic = 0;
    int notPublicNotStaticButActuallyPublicStatic = 0;
    final int notPublicNotStaticButActuallyPublicStaticFinal = 0;

    private void privateMethod() {
        System.out.println("I am private NON-static method in interface!");
    }

    private static void privateStaticMethod() {
        System.out.println("I am private static method in interface!");
    }

}
