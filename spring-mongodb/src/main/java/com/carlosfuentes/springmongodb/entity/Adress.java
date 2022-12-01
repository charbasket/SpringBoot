package com.carlosfuentes.springmongodb.entity;

import lombok.Data;

@Data
public class Adress {
    private String country;
    private String city;
    private String postCode;

    public Adress(String country, String city, String postCode) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
    }
}