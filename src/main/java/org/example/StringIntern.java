package org.example;

public class StringIntern {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println("s1 (var literal) == s2 (new str): " + (s1 == s2));
        System.out.println("s1 (var literal) == s3 (s1.intern): " + (s1 == s3));
        System.out.println("s1 (var literal) == s4 (s2.intern): " + (s1 == s4));
        System.out.println("s4 (s2.intern) == s2 (new str): " + (s4 == s2));
//        throw new AssertionError("my message", new RuntimeException());
    }
}
