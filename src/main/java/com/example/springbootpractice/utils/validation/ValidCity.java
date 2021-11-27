package com.example.springbootpractice.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint annotation for City Validation
 *
 * @author Tairi
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = {CityValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCity {
    String message() default "{messages.constraints.invalid-city}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
