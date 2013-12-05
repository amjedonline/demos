package com.faktor73.validation.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

public class SelectiveValidLengthValidator implements
        ConstraintValidator<SelectiveValidLength, String> {

    private Size[] sizes;

    public void initialize(SelectiveValidLength constraintAnnotation) {
        this.sizes = constraintAnnotation.sizes();
    }

    public boolean isValid(String object,
            ConstraintValidatorContext constraintContext) {

        System.out.println(object+"*******");
        for (Size size : sizes) {
            System.out.print("Min:" + size.min() + " Max:" + size.max()
                    + " for classes");
            for (Class clazz : size.groups()) {
                System.out.print(clazz.getName());
            }
            System.out.println();
        }

        if (object == null)
            return true;

        return object.equals(object.toUpperCase());
    }
}