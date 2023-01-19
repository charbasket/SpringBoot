package com.in28minutes.rest.webservices.restfulwebservices.Beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "Birthdate should be in the past")
    @JsonProperty("Birth Date")
    private LocalDate birthDate;
}
