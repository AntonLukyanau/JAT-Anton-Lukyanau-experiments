package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.oop.immutability.MyClass;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Person implements Serializable {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String nationality;
    @JsonProperty
    private String identityNumber;

    private MyClass myClass; //для демонстрации глубокого копирования Person

    @JsonIgnore
    private Gender gender;

    public Person(Gender gender, String name) {
        this(0, name, "", "", "", null, gender);
    }

    public Person(int id, String name, String surname, String nationality, String identityNumber) {
        this(id, name, surname, nationality, identityNumber, null, Gender.OTHER);
    }

    public Person(Person person) {
        this(person.id, person.name, person.surname, person.nationality, person.identityNumber, new MyClass(person.myClass), person.gender);
        this.myClass.setParent(this);
//        this.id = person.id;
//        this.name = person.name;
//        this.surname = person.surname;
//        this.nationality = person.nationality;
//        this.identityNumber = person.identityNumber;
//        this.gender = person.gender;
    }

}
