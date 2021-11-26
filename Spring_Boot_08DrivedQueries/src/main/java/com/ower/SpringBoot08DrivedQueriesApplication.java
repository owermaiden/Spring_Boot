package com.ower;

import com.ower.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBoot08DrivedQueriesApplication {

    @Autowired
    RegionRepository regionRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08DrivedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){
        System.out.println("-------------------Regions start---------------------");

        System.out.println("findRegionsByCountry: "+ regionRepository.findRegionsByCountry("Canada"));
        System.out.println("findByCountry: "+ regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: "+ regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findRegionsByCountryContaining: "+ regionRepository.findRegionsByCountryContaining("United"));
        System.out.println("findRegionsByCountryContainingOrderByCountry: "+ regionRepository.findRegionsByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: "+ regionRepository.findTop2ByCountry("Canada"));

        System.out.println("-------------------Regions ends----------------------");
    }
}
