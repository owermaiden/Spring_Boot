package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name= "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;
    private String model;
}
