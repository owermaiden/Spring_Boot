package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne                                          // mappedBy cannot be used in Many to One...
    private Person person;

}
