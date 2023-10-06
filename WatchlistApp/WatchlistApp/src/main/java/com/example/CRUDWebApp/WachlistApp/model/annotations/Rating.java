package com.example.CRUDWebApp.WachlistApp.model.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingLogic.class)
public @interface Rating {
    String message() default "Rating must be given between 5.0 and 10";

    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}
