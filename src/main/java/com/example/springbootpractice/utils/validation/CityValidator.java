package com.example.springbootpractice.utils.validation;

import com.example.springbootpractice.models.City;
import com.example.springbootpractice.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Constraint validator to check whether city is valid
 *
 * @author Tairi
 */
@Component
public class CityValidator implements ConstraintValidator<ValidCity, City> {
    @Autowired
    private CityService cityService;

    @Override
    public void initialize(ValidCity constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(City city, ConstraintValidatorContext constraintValidatorContext) {
        return cityService.findAllCities().stream()
                .anyMatch(repoCity -> repoCity.getId().equals(city.getId())
                        && repoCity.getName().equals(city.getName()));
    }
}
