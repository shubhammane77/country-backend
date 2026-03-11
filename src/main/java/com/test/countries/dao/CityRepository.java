package com.test.countries.dao;

import com.test.countries.model.City;
import com.test.countries.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByCountryId(Long id);
}
