package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringValidEmail;

public class StringValidEmailValidator implements BaseObjectValidator<String> {

	@Override
	public void validate(String fieldName, Annotation annotation, String object) {
		if (object != null) {
			if (!object.matches("^(.+)@(.+)$")) {
				StringValidEmail ann = (StringValidEmail)annotation;
				throw BouncerException.withMessage(String.format(ann.message(), fieldName));
			}
		}
	}

}
