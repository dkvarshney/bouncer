package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.NotNull;

public class NotNullValidator implements BaseObjectValidator<Object> {

	@Override
	public void validate(String fieldName, Annotation annotation, Object object) {
		if (object == null) {
			NotNull ann = (NotNull) annotation;
			throw BouncerException.withMessage(String.format(ann.message(), fieldName));
		}
	}
}
