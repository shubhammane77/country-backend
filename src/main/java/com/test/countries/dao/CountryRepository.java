package com.test.countries.dao;

import com.test.countries.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("SELECT c FROM Country c LEFT JOIN FETCH c.cityList")
    List<Country> findAllWithCities();
}
