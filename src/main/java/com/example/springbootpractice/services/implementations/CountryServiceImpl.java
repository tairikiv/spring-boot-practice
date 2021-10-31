package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.Country;
import com.example.springbootpractice.repositories.CountryRepository;
import com.example.springbootpractice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}
