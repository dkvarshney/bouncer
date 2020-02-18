package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringPattern;

public class StringPatternValidator implements BaseObjectValidator {

	@Override
	public void validate(String fieldName, Annotation annotation, Object object) {
		if (object != null) {
			StringPattern ann = (StringPattern)annotation;
			if (!object.toString().matches(ann.regexp())) {
				throw BouncerException.withMessage(String.format(ann.message(), fieldName, ann.regexp()));
			}
		}
	}
}
