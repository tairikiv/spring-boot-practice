package com.example.springbootpractice.services;

import com.example.springbootpractice.models.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAllCountries();
}
