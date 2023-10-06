package com.example.CRUDWebApp.WachlistApp.model.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityLogic implements ConstraintValidator<Priority, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.trim().length() >= 1 && "LMH".contains(s.trim());
    }
}
