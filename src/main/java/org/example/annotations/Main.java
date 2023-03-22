package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyInheritedAnnotation {
    String value();
}

@MyInheritedAnnotation(value="class annotation")
class BaseClass {
}

/*
 * !!! There is NO annotation
 */
class SubClass extends BaseClass {
}

public class Main {
    public static void main(String[] args) {
        MyInheritedAnnotation annotation = SubClass.class.getAnnotation(MyInheritedAnnotation.class);
        System.out.println(annotation.value());


    }
}
