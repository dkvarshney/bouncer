package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.StringLengthRangeValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringLengthRange {
	
	int minLength() default Integer.MIN_VALUE;
	
	int maxLength() default Integer.MAX_VALUE;
	
	Class<? extends BaseObjectValidator<String>> validator() default StringLengthRangeValidator.class;
	
	String message() default "%s should be between %d and %d.";
}