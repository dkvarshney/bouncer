package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.StringValidUrl;

public class StringValidUrlValidator implements BaseObjectValidator<String> {

	@Override
	public void validate(String fieldName, Annotation annotation, String object) {
		if (object != null) {
			try {
				new URL(object);
			} catch (MalformedURLException e) {
				StringValidUrl ann = (StringValidUrl)annotation;
				throw BouncerException.withMessage(String.format(ann.message(), fieldName));
			}	
		}
	}
}
