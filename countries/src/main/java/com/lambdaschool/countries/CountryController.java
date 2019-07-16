package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Adding @RestController tells the app were going to be controlling this with REST


@RequestMapping("/all")


public class CountryController

{
    // controller is responsible for allowing the outside world to interact with the system we created.
    // our applications generate api's, this one is using rest.

    //localhost:8080/data/allCountries endoint should return all employees

    @RequestMapping(value = "/countries", produces = {"application/json"})
    // all endpoints produce json (java object notation).
    public ResponseEntity<?> getAllCountries(){
        // in version 11+ we can use a ? as a "wild card" if we dont know the data type
        return new ResponseEntity<>(CountriesApplication.countryList, HttpStatus.OK);
        //returns the http status of OK so the front end engineer knows things are working?

    }



}