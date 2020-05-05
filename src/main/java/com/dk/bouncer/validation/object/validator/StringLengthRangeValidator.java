package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringLengthRange;

public class StringLengthRangeValidator implements BaseObjectValidator<String> {

	@Override
	public void validate(String fieldName, Annotation annotation, String object) {
		if (object != null) {
			StringLengthRange ann = (StringLengthRange)annotation;
			if (object.length() < ann.minLength() || object.length() > ann.maxLength()) {
				throw BouncerException.withMessage(
						String.format(ann.message(), fieldName, ann.minLength(), ann.maxLength()));
			}
		}
	}
}
