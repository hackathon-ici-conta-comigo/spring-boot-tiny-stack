package com.codegik.tinystack.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Embedded
    private Location location;

    @Column(name = "street")
    private String street;

    @Column(name = "complement")
    private String complement;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "number")
    private Long number;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public static synchronized Address create() {
        return new Address();
    }

    public Address withLocation(final Location location) {
        this.location = location;
        return this;
    }

    public Address withStreet(final String street) {
        this.street = street;
        return this;
    }

    public Address withComplement(final String complement) {
        this.complement = complement;
        return this;
    }

    public Address withCity(final String city) {
        this.city = city;
        return this;
    }

    public Address withState(final String state) {
        this.state = state;
        return this;
    }

    public Address withCountry(final String country) {
        this.country = country;
        return this;
    }

    public Address withNumber(final Long number) {
        this.number = number;
        return this;
    }

}
