package org.example.iscompile;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Singleton> singletonClass = Singleton.class;
        String s = singletonClass.toGenericString();
        System.out.println(s);
        Singleton.<String>getElem("dfw000");
        List<String> list = new ArrayList<>();
    }
}
