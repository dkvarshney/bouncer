package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;
import java.util.Base64;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringValidBase64;

public class StringValidBase64Validator implements BaseObjectValidator {

	@Override
	public void validate(String fieldName, Annotation annotation, Object object) {
		if (object != null) {
			try {
				Base64.getDecoder().decode(object.toString());
			} catch (IllegalArgumentException e) {
				StringValidBase64 ann = (StringValidBase64)annotation;
				throw BouncerException.withMessage(String.format(ann.message(), fieldName));
			}	
		}
	}
}
