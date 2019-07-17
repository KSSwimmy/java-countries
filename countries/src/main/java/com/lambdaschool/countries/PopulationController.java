package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
// Adding @RestController tells the app we're going to be controlling this with REST
@RequestMapping("/population")

public class PopulationController

{
   // localhost:2007/population/size/{people}
    //return the countries that have a population equal to or greater than the given population

    @GetMapping(value = "/size/{people}")
    public ResponseEntity<?> returnCountyPopulation(@PathVariable long people)

    {
        ArrayList<Country> returnArrayList = CountriesApplication.ourCountries.findCountry(c -> c.getPopulation() >= (people));
        //returnArrayList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }

    // localhost:2007/population/min
    //return the country with the smallest median age
    @GetMapping(value = "/min")
    public ResponseEntity<?> returnCountyPopulation()
    {
        CountriesApplication.ourCountries.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        Country returnArrayList = CountriesApplication.ourCountries.countryList.get(0);
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }

    //localhost:2007/population/max
    @GetMapping(value = "/max")
    public ResponseEntity<?> returnCountyPopulationMax()
    {
        CountriesApplication.ourCountries.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        Country returnArrayList = CountriesApplication.ourCountries.countryList.get(0);
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }

}
