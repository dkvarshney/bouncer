package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringPattern;

public class StringPatternValidator implements BaseObjectValidator<String> {

	@Override
	public void validate(String fieldName, Annotation annotation, String object) {
		if (object != null) {
			StringPattern ann = (StringPattern)annotation;
			if (!object.matches(ann.regexp())) {
				throw BouncerException.withMessage(String.format(ann.message(), fieldName, ann.regexp()));
			}
		}
	}
}
