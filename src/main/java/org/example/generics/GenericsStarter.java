package org.example.generics;

import org.example.generics.container.Container;
import org.example.generics.model.Camera;
import org.example.generics.model.Phone;
import org.example.generics.model.Product;


/**
 Задача: Реализовать иерархию классов Product -> Camera, Product -> Phone.
 Родительский класс Product должен реализовывать Comparable.
 При этом при помощи дженериков нужно ограничить сравнение таким образом, чтобы камера могла быть сравнена только с камерой,
 телефон только с телефоном. Сравнение камеры и телефона методом compareTo должно вызывать ошибку компиляции.
 */
public class GenericsStarter {
    public static void main(String[] args) {

        String[] strings = {
                "1",
                "2",
                "3"
        };
        Integer[] integers = {1, 2, 3, 4};
        Integer methodResInt = Container.<Integer>method(integers);
        String methodResStr = Container.<String>method(strings);
        System.out.println(methodResInt);
        System.out.println(methodResStr);


        Phone phone1 = new Phone("phone1", 150L, "Galaxy S3", 128);
        Phone phone2 = new Phone("phone2", 160L, "Galaxy S5", 256);

        Camera camera1 = new Camera("camera1", 140L, 120000, "Nokia");
        Camera camera2 = new Camera("camera2", 140L, 130000, "Sony");

        Product<Camera> cameraAsProduct = new Camera("camera product", 150L, 1000000, "Samsung");


        System.out.println(camera1.compareTo(camera2));
//        System.out.println(camera1.compareTo(phone1));            //there is compiling error

        System.out.println(phone2.compareTo(phone1));
//        System.out.println(phone2.compareTo(camera1));            //there is compiling error
//        System.out.println(phone2.compareTo(cameraAsProduct));    //there is compiling error

    }
}
