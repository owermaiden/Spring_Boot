package com.cybertek.entity;

public class Vehicle {

    private static int count;
    private String make;
    private int mile;

    public Vehicle(String make, int mile) {
        this.make = make;
        this.mile = mile;
    }

    public void changeGear(){
        System.out.println("gear changed");
    }
}
