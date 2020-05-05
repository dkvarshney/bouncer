package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

public interface BaseObjectValidator<T> {

	public static String DEFAULT_FRIENDLY_NAME = "";
	
	public void validate(String fieldName, Annotation annotation, T object);
}
