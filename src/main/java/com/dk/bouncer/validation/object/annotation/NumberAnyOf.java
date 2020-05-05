package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.NumberAnyOfValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberAnyOf {
		
	Class<? extends BaseObjectValidator<Number>> validator() default NumberAnyOfValidator.class;
		
	
	String message() default "invalid attribute value.";
}
