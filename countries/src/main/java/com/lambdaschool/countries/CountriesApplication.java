package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class CountriesApplication
{
    static CountryList ourCountries;
    public static void main(String[] args)
    {
        ourCountries = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
