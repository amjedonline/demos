package com.faktor73.validation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SelectiveValidLengthValidator.class)
@Documented
public @interface SelectiveValidLength {

    String message() default "{validator.uppercase}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    Size[] sizes() default {}; 

}