package com.test.countries.controller;

import com.test.countries.model.City;
import com.test.countries.model.Country;
import com.test.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CountriesController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    @CrossOrigin
    public List<Country> countries() {
        return countryService.getCountryList();
    }

    @GetMapping("/cities/{countryId}")
    @CrossOrigin
    public Page<City> getCities(
            @PathVariable("countryId") Long countryId,
            @RequestParam("index") int index
    ) {
        return countryService.getCityList(countryId, index, 3);
    }
}