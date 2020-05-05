package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.StringNoneOfValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringNoneOf {
	
	String[] values();
	
	boolean ignoreCase() default false;
	
	Class<? extends BaseObjectValidator<String>> validator() default StringNoneOfValidator.class;
	
	String message() default "%s is not valid.";
}