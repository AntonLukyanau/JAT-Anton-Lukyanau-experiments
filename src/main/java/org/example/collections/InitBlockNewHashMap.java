package org.example.collections;

import java.util.HashMap;
import java.util.Map;

/**
  Задача: Проверить какой тип у Map, заполненного при помощи кода:
  Map<String, String> map = new HashMap<>(){{
              put("1", "One");
          }};
 */
public class InitBlockNewHashMap {
    private static Map<String, String> map = new HashMap<>(){
        {
            put("1", "One");
        }
    };

    //Всё-таки это создание анонимного класса
    public static void main(String[] args) {
        Class<? extends Map> mapClass = map.getClass();
        System.out.println(mapClass.getName());
        System.out.println(mapClass.getSuperclass().getName());
    }
}
