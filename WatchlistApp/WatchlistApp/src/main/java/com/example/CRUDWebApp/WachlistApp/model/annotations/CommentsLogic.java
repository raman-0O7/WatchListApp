package com.example.CRUDWebApp.WachlistApp.model.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CommentsLogic implements ConstraintValidator<Comments, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.trim().length() <= 50;
    }
}
