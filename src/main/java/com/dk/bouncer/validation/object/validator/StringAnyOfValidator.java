package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringAnyOf;

public class StringAnyOfValidator implements BaseObjectValidator<String> {

	@Override
	public void validate(String fieldName, Annotation annotation, String object) {
		if (object != null) {
			boolean found = false;
			StringAnyOf ann = (StringAnyOf) annotation;
			if (ann.ignoreCase()) {
				found = Arrays.stream(ann.values()).anyMatch( v -> v.equalsIgnoreCase(object));
			} else {
				found = Arrays.stream(ann.values()).anyMatch( v -> v.equals(object));				
			}
			if (!found) {
				throw BouncerException.withMessage(String.format(ann.message(), fieldName));	
			}	
		}
	}
}
