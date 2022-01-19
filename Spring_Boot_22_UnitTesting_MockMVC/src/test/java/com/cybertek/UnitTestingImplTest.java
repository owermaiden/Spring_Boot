package com.cybertek;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitTestingImplTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    UnitTestingImpl unitTesting;

    @Test
    void calculateSum() {

        UnitTestingImpl unitTesting = new UnitTestingImpl();
        int actual = unitTesting.calculateSum(new int[]{1,2,3});
        assertEquals(6, actual);
    }

    @Test
    void calculateSumUsingDataService() {

        DataRepositoryImpl dataRepository = new DataRepositoryImpl();      // without mock we need to bring our repo here..
        UnitTestingImpl unitTesting = new UnitTestingImpl(dataRepository); // inject repo to your service..
        int actual = unitTesting.calculateSumUsingDataService();           // this is what we test..
        assertEquals(6,actual);
    }

    @Test
    void calculateSumUsingDataService_Mock(){

        when(dataRepository.findAll()).thenReturn(new int[]{1,2,3}).thenReturn(new int[]{5,5,5});

        int actual = unitTesting.calculateSumUsingDataService();
        int actual2 = unitTesting.calculateSumUsingDataService();

        assertEquals(6,actual);
        assertEquals(15,actual2);
    }


    @Test
    void calculateSumUsingDataService_Mock_withParameter(){

        when(dataRepository.findById(2)).thenReturn(new int[]{10,10,10});
        int actual = unitTesting.calculateSumUsingDataService_withParameter();
        assertEquals(30,actual);

    }

    @Test
    void calculateSumUsingDataService_Mock_withGenericParameter(){

        when(dataRepository.findById(anyInt())).thenReturn(new int[]{10,10,10});
        int actual = unitTesting.calculateSumUsingDataService_withParameter();
        assertEquals(30,actual);

        verify(dataRepository).findById(2);
        verify(dataRepository,times(2)).findById(2);
    }
}