package com.example.CRUDWebApp.WachlistApp.model.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommentsLogic.class)
public @interface Comments {
    String message() default "Comments character must be atmost 50 characters";

    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};

}
