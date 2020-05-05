package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.NumberDivisibleValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberDivisibleBy {
		
	int value();
	
	Class<? extends BaseObjectValidator<Number>> validator() default NumberDivisibleValidator.class;
	
	String message() default "%s should be divisible by %s.";
}