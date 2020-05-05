package com.dk.bouncer.validation.attribute.validator;

public class ObjectValidator<T extends Object> extends BaseAttributeValidator<T, ObjectValidator<T>> {

	public ObjectValidator(String fieldName, T value) {
		super(fieldName, value);
	}

}
