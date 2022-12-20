package org.example.serializable.vs.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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

}
