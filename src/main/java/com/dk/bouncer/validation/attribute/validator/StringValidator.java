package com.dk.bouncer.validation.attribute.validator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Collection;
import java.util.regex.Pattern;

import com.dk.bouncer.exception.BouncerException;

public class StringValidator extends BaseAttributeValidator<String, StringValidator> {

	public StringValidator(String fieldName, String value) {
		super(fieldName, value);
	}

	public StringValidator isNotBlank() {
		return this.isNotBlank(String.format("%s should not be blank.", this.attributeName));
	}

	public StringValidator isNotBlank(String message) {
		if (object == null) {
			return this;
		}

		if (object.isEmpty()) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}
	
	public StringValidator isNotLongerThan(int length) {
		return this.isNotLongerThan(length, String.format("%s should not be longer than %d.", this.attributeName, length));
	}

	public StringValidator isNotLongerThan(int length, String message) {
		if (object == null) {
			return this;
		}

		if (object.length() > length) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}


	public StringValidator isNotShorterThan(int length) {
		return this.isNotShorterThan(length, String.format("%s should not be shorter than %d chars.", this.attributeName, length));
	}

	public StringValidator isNotShorterThan(int length, String message) {
		if (object == null) {
			return this;
		}

		if (object.length() < length) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public StringValidator isValidEmail() {
		return this.isValidEmail(String.format("%s should be a valid email address.", this.attributeName));
	}
	
	public StringValidator isValidEmail(String message) {
		if (this.object == null) {
			return this;
		}
		if (!this.object.matches("^(.+)@(.+)$")) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}
	
	public StringValidator isValidUrl() {
		return this.isValidUrl(String.format("%s should be a valid url.", this.attributeName));
	}

	public StringValidator isValidUrl(String message) {
		if (this.object == null) {
			return this;
		}
		try {
			new URL(this.object);
			return this;
		} catch (MalformedURLException e) {
			throw BouncerException.withMessage(message);
		}
	}

	public StringValidator isValidBase64() {
		return this.isValidBase64(String.format("%s should be a valid base64 encoded string.", this.attributeName));
	}

	public StringValidator isValidBase64(String message) {
		if (object == null) {
			return this;
		}
		try {
			Base64.getDecoder().decode(object);			
		} catch (IllegalArgumentException e) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public StringValidator matches(String regexp) {
		return this.matches(regexp, String.format("%s should match with pattern: %s.", this.attributeName, regexp));
	}

	public StringValidator matches(String regexp, String message) {
		if (object == null) {
			return this;
		}

		Pattern pattern = Pattern.compile(regexp);
		if (!pattern.matcher(object).matches()) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public StringValidator isAnyOf(Collection<String> others, boolean ignoreCase) {
		return this.isAnyOf(others, ignoreCase, String.format("%s is not valid.", this.attributeName));
	}

	public StringValidator isAnyOf(Collection<String> others, boolean ignoreCase, String message) {
		if (object == null) {
			return this;
		}

		boolean found = false;
		if (ignoreCase) {
			found = others.stream().anyMatch(other -> other.equalsIgnoreCase(object));        	
		} else {
			found = others.stream().anyMatch(other -> other.equals(object));
		}

		if (!found) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}
}