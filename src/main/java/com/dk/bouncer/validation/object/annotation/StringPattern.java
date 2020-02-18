package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.StringPatternValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringPattern {
		
	String regexp();
	
	Class<? extends BaseObjectValidator> validator() default StringPatternValidator.class;
	
	String message() default "%s should match the pattern %s";
}