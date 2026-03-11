package com.test.countries.service;

import com.test.countries.dao.CountryRepository;
import com.test.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountryList(){
        return countryRepository.findAll();
    }

}
