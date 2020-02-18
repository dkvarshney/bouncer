package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringAnyOf;

public class StringAnyOfValidator implements BaseObjectValidator {

	@Override
	public void validate(String fieldName, Annotation annotation, Object object) {
		if (object != null) {
			boolean found = false;
			StringAnyOf ann = (StringAnyOf) annotation;
			if (ann.ignoreCase()) {
				found = Arrays.stream(ann.values()).anyMatch( v -> v.equalsIgnoreCase(object.toString()));
			} else {
				found = Arrays.stream(ann.values()).anyMatch( v -> v.equals(object.toString()));				
			}
			if (!found) {
				throw BouncerException.withMessage(String.format(ann.message(), fieldName));	
			}	
		}
	}
}
