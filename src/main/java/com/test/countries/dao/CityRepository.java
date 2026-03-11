package com.test.countries.dao;

import com.test.countries.model.City;
import com.test.countries.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CityRepository extends JpaRepository<City, Long> {
    Page<City> findByCountryId(Long countryId, Pageable pageable);
}
