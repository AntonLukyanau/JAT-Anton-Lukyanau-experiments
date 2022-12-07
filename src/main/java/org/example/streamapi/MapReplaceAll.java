package org.example.streamapi;

import java.util.HashMap;
import java.util.Map;

public class MapReplaceAll {
    static Map<String, String> m1;
    static Map<String, String> m2;

    static {
        m1 = new HashMap<>();
        m1.put("1", "1111");
        m1.put("2", "2222");

        m2 = new HashMap<>();
        m2.put("1", "AAAA");
        m2.put("2", "BBBB");
    }

    public static void main(String[] args) {
        m1.replaceAll((key, val) -> m2.put(key, val));
        System.out.println("m1: " + m1);
        System.out.println("m2: " + m2);
    }

}
