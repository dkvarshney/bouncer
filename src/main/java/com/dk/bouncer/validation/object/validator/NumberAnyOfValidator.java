package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;

public class NumberAnyOfValidator implements BaseObjectValidator<Number> {

	@Override
	public void validate(String fieldName, Annotation annotation, Number object) {
		throw BouncerException.withMessage("not implemented yet.");
	}
}
