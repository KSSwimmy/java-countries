package com.lambdaschool.countries;

import static java.lang.Character.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
// Adding @RestController tells the app we're going to be controlling this with REST
@RequestMapping("/names")

public class CountryController

{
    // controller is responsible for allowing the outside world to interact with the system we created.
    // our applications generate api's, this one is using rest.


    //
    //    @GetMapping(value = "/countries", produces = {"application/json"})
    //    // all endpoints produce json (java object notation).
    //
    //    public ResponseEntity<?> getAllCountries()
    //    // in version 11+ we can use a ? as a "wild card" if we dont know the data type
    //    {
    //
    //        return new ResponseEntity<>(CountriesApplication.ourCountries, HttpStatus.OK);
    //        //returns the http status of OK so the front end engineer knows things are working?
    //
    //
    //        @GetMapping(value = "") public ResponseEntity<?> getCountryLetter (
    //        @PathVariable
    //        char letter)
    //        {
    //            CountryList<Country> rtnCountry = CountriesApplication.ourCountries.findCountries(c -> c.getCountryName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
    //            rtnCountry.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
    //            return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    //        }
    //localhost:2007/names/all
    @GetMapping(value = "/all")
    public ResponseEntity<?> returnAllCountries() //returnAllCountries() is a banana name that describe what the method is doing
    {
        CountriesApplication.ourCountries.countryList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(CountriesApplication.ourCountries.countryList, HttpStatus.OK);
    }

    //localhost:2007/names/start/{letter}

    // This is sorting the ArrayList in CountryList by using the compareToIgnoreCase we are telling
    // it to ignore the casing and compare to object 2.
    @GetMapping(value = "/start/{letter}")
    public ResponseEntity<?> return1stLetter(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> returnArrayList = CountriesApplication.ourCountries.findCountry(c -> c.getCountryName().toUpperCase().charAt(0) == toUpperCase(letter));
        returnArrayList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }

    //localhost:2007/names/size/{number}

    //return the countries alphabetically that have a name equal to or longer than the given length

    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> returnCountyLength( @PathVariable int number)
    {
        ArrayList<Country> returnArrayList = CountriesApplication.ourCountries.findCountry(c -> c.getCountryName().length() >= (number));
        returnArrayList.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(returnArrayList, HttpStatus.OK);
    }


}