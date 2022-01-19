package com.cybertek;

public class DataRepositoryImpl implements DataRepository {

    @Override
    public int[] findAll() {
        return new int[]{1,2,3};
    }

    @Override
    public int[] findById(int id) {
        return new int[]{10,10,10};
    }
}