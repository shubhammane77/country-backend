package com.test.countries.controller;

import com.test.countries.model.City;
import com.test.countries.model.Country;
import com.test.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CountriesController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> countries() {
        return countryService.getCountryList();
    }

}