package com.hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable
/*
 * Adress icin ayri bir tablo olusmasin, Ama Adress sinifindaki degiskenler ,
 * Student tablosunda kolon olarak eklenmesini sagliyor
 */

public class Adress {

    private String street;

    private String city;

    private String country;
    private String zipCode;



    //Getter-Setter;
    public String street() {
        return street;
    }

    public Adress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String city() {
        return city;
    }

    public Adress setCity(String city) {
        this.city = city;
        return this;
    }

    public String country() {
        return country;
    }

    public Adress setCountry(String country) {
        this.country = country;
        return this;
    }

    public String zipCode() {
        return zipCode;
    }

    public Adress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }


    //toString **************************************

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }




}
