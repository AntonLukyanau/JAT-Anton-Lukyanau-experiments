package org.example.reflection.copying.model;

import java.util.Objects;

public class Address {

    private final String country;
    private final String city;
    private final Street street;
    private final String house;
    private final Integer flat;

    public Address(String country, String city, Street street, String house, Integer flat) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Street getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public Integer getFlat() {
        return flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getCountry(), address.getCountry())
                && Objects.equals(getCity(), address.getCity())
                && Objects.equals(getStreet(), address.getStreet())
                && Objects.equals(getHouse(), address.getHouse())
                && Objects.equals(getFlat(), address.getFlat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCity(), getStreet(), getHouse(), getFlat());
    }
}