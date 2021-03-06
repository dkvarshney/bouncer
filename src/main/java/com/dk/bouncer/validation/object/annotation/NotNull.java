package com.dk.bouncer.validation.object.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dk.bouncer.validation.object.validator.BaseObjectValidator;
import com.dk.bouncer.validation.object.validator.NotNullValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
		
	Class<? extends BaseObjectValidator<Object>> validator() default NotNullValidator.class;
	
	String message() default "%s should not be null.";
}
