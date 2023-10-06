package com.example.CRUDWebApp.WachlistApp.model.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingLogic implements ConstraintValidator<Rating, Double> {
    @Override
    public boolean isValid(Double o, ConstraintValidatorContext constraintValidatorContext) {
        return o > 5.0 && o < 10;
    }
}
