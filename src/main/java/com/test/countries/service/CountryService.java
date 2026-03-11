package com.test.countries.service;

import com.test.countries.dao.CityRepository;
import com.test.countries.dao.CountryRepository;
import com.test.countries.model.City;
import com.test.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Country> getCountryList(){
        return countryRepository.findAllWithCities();
    }

    public List<City> getCityList(Long countryId){
        return cityRepository.findByCountryId(countryId);
    }

}
