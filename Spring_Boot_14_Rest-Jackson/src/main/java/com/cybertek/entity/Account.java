package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account_details")
@ToString
@JsonIgnoreProperties(value = {"state", "postalCode"}, ignoreUnknown = true) // if field is unknown then do not serialize-deserialize to protect hackers to unintentionally reach our code
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;

    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "account")
    @JsonBackReference  // whenever somebody calls account api then don't give them user, same as JsonIgnore, but we used this because of onetoone relationship in order to track what is happening in user entity side
    private User user;

    public Account(String name, String address, String country, String state, String city, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
