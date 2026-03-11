package com.test.countries.controller;

import com.test.countries.model.City;
import com.test.countries.model.Country;
import com.test.countries.service.CountryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<City> countries(@PathVariable("countryId") Long countryId) {
        return countryService.getCityList(countryId);
    }
}