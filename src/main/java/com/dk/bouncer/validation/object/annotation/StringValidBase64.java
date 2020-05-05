package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.StringValidBase64Validator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValidBase64 {
		
	Class<? extends BaseObjectValidator<String>> validator() default StringValidBase64Validator.class;
	
	String message() default "%s should be a valid base64 encoded string.";
}