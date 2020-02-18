package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.NumberValueRangeValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberValueRange {
		
	Class<? extends BaseObjectValidator> validator() default NumberValueRangeValidator.class;
	
	String message() default "invalid attribute value.";
}