package com.sample.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    @Size(max = 100)
    @Column(name = "address_line_1")
    private String addressLine1;


    @Size(max = 100)
    @Column(name = "address_line_2")
    private String addressLine2;

     @Size(max = 100)
     @Column(name = "city")
     private String city;

     @Size(max = 100)
     @Column(name = "country")
     private String country;

    @Size(max = 6)
    @Column(name = "postcode")
    private String postCode;


    public Address() {

    }

    public Address(String addressLine1, String addressLine2, String city, String country, String postCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}