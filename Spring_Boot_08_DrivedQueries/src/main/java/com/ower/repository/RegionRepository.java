package com.ower.repository;

import com.ower.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    //Display all regions in Canada
    List<Region> findRegionsByCountry(String country);
    List<Region> findByCountry(String country);

    //Display all regions in Canada, without duplicates..
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country names includes "United"
    List<Region> findRegionsByCountryContaining(String country);

    //Display all regions with country name includes "United" in order
    List<Region> findRegionsByCountryContainingOrderByCountry(String country);

    //Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);

}
