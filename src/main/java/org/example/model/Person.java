package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
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

    @JsonIgnore
    private Gender gender;

    public Person(Gender gender, String name) {
        this(0, name, "", "", "", gender);
    }

    public Person(int id, String name, String surname, String nationality, String identityNumber) {
        this(id, name, surname, nationality, identityNumber, Gender.OTHER);
    }
}
