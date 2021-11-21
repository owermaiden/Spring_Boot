package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id // Define your primary key...
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String make;
    private String model;

}
