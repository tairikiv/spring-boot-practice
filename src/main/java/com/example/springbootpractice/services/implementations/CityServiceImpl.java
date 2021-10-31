package com.example.springbootpractice.services.implementations;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.repositories.CityRepository;
import com.example.springbootpractice.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }
}
