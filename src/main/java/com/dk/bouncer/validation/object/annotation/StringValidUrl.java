package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.StringValidUrlValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValidUrl {
		
	Class<? extends BaseObjectValidator> validator() default StringValidUrlValidator.class;
	
	String message() default "%s should be a valid url.";
}