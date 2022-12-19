package org.example.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InitBlockNewHashMap {
    private static Map<String, String> map = new HashMap<>(){
        {
            put("1", "One");
        }
    };

    //всё таки это создание анонимного класса
    public static void main(String[] args) {
        Class<? extends Map> mapClass = map.getClass();
        System.out.println(mapClass.getName());
        System.out.println(mapClass.getSuperclass().getName());
    }
}
