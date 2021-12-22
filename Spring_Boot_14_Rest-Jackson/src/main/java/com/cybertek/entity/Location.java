package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernate_Lazy_Initializer"}, ignoreUnknown = true) // because fetch type lazy
public class Location extends BaseEntity{

    private String name;
    private BigDecimal latitude;
    private BigDecimal langitude;
    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;

    // Adding @OnetoMany is not a best practice... We have to drop the table with mappedBy.. anyway.. So there is no need...


    public Location(String name, BigDecimal latitude, BigDecimal langitude, String address, String postalCode, String country, String state, String city) {
        this.name = name;
        this.latitude = latitude;
        this.langitude = langitude;
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
    }
}
