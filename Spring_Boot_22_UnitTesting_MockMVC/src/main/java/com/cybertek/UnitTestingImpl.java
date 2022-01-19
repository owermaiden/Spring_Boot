package com.cybertek;

import java.util.Arrays;

public class UnitTestingImpl {

    DataRepository dataRepository;

    public UnitTestingImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public UnitTestingImpl() {
    }

    public int calculateSum(int[] data){
        int sum=0;
        return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService(){
        int sum=0;
        return Arrays.stream(dataRepository.findAll()).sum();
    }

    public int calculateSumUsingDataService_withParameter(){
        int sum=0;
        return Arrays.stream(dataRepository.findById(2)).sum();

    }
}