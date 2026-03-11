package com.test.countries.service;

import com.test.countries.dao.CityRepository;
import com.test.countries.dao.CountryRepository;
import com.test.countries.model.City;
import com.test.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return countryRepository.findAll();
    }

    public Page<City> getCityList(Long countryId, int pageIndex, int pageSize){
        PageRequest pageable = PageRequest.of(pageIndex, pageSize);
        return cityRepository.findByCountryId(countryId, pageable);
    }

}
