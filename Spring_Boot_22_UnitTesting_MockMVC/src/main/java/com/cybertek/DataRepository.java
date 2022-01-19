package com.cybertek;

public interface DataRepository {
    int[] findAll();
    int[] findById(int id);
}