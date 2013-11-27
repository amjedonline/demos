package com.faktor73.validation.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpperCaseValidator implements
        ConstraintValidator<UpperCase, String> {

    public void initialize(UpperCase constraintAnnotation) {
        // nothing to do
    }

    public boolean isValid(String object,
            ConstraintValidatorContext constraintContext) {

        if (object == null)
            return true;

        return object.equals(object.toUpperCase());
    }

}