package com.in28minutes.rest.webservices.restfulwebservices.Beans;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
// @JsonIgnoreProperties({"v1", "v2"})

// For dynamic filtering
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String v1;
    // @JsonIgnore
    private String v2;
    private String v3;
}
